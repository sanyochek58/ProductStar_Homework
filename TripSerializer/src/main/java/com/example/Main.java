package com.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    private static final List<String> COUNTRIES = Arrays.asList(
            "Россия",
            "Казахстан",
            "Беларусь",
            "Армения",
            "Грузия",
            "Турция",
            "Египет",
            "ОАЭ",
            "Таиланд",
            "Вьетнам",
            "Китай",
            "Япония",
            "Индия",
            "Италия",
            "Испания",
            "Франция",
            "Германия",
            "Греция",
            "Сербия",
            "Бразилия"
    );

    private static final List<String> SURNAMES = Arrays.asList(
            "Иванов", "Петров", "Сидоров", "Кузнецов", "Смирнов",
            "Попов", "Васильев", "Новиков", "Морозов", "Волков"
    );

    private static final List<String> MALE_NAMES = Arrays.asList(
            "Александр", "Дмитрий", "Максим", "Сергей", "Андрей", "Никита"
    );

    private static final List<String> FEMALE_NAMES = Arrays.asList(
            "Анна", "Мария", "Елена", "Ольга", "Дарья", "Екатерина"
    );

    private static final Random RANDOM = new Random();

    private static List<User> generateUsers(int count) {
        List<User> users = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            boolean male = RANDOM.nextBoolean();

            String surname = randomOf(SURNAMES);
            String firstName = male ? randomOf(MALE_NAMES) : randomOf(FEMALE_NAMES);

            if (!male) {
                surname = surname + "а";
            }

            User user = new User.Builder(surname)
                    .firstName(firstName)
                    .age(18 + RANDOM.nextInt(50))
                    .sex(male ? "мужской" : "женский")
                    .numberPassport(String.format("%06d", RANDOM.nextInt(1_000_000)))
                    .codePassport(String.format("%04d", RANDOM.nextInt(10_000)))
                    .build();

            users.add(user);
        }

        return users;
    }

    private static List<Trip> generateDataOfTrips() {
        List<Trip> trips = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String from = randomOf(COUNTRIES);
            String to = randomOf(COUNTRIES);

            while (to.equals(from)) {
                to = randomOf(COUNTRIES);
            }

            List<User> users = generateUsers(1 + RANDOM.nextInt(3));
            trips.add(new Trip(users, new Destination(from, to)));
        }

        return trips;
    }

    private static <T> T randomOf(List<T> source) {
        return source.get(RANDOM.nextInt(source.size()));
    }

    private static void processSerialize(List<Trip> trips) throws IOException {
        System.out.println("Процесс сериализации...");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.cer"))) {
            oos.writeObject(trips);
            System.out.println("Файл сохранён как data.cer");
        }
    }

    private static List<Trip> processDeserialize() throws IOException, ClassNotFoundException {
        System.out.println("Процесс десериализации...");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.cer"))) {
            List<Trip> trips = (List<Trip>) ois.readObject();
            System.out.println("Файл data.cer прочитан");
            return trips;
        }

    }

    private static ObjectMapper createMapper() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(User.class, new UserDeserializer());
        module.addDeserializer(Destination.class, new DestinationDeserializer());
        module.addDeserializer(Trip.class, new TripDeserializer());

        return new ObjectMapper().registerModule(module);
    }

    private static class UserDeserializer extends JsonDeserializer<User> {

        @Override
        public User deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            JsonNode node = parser.getCodec().readTree(parser);

            return new User.Builder(node.get("surname").asText())
                    .firstName(node.get("firstName").asText())
                    .age(node.get("age").asInt())
                    .sex(node.get("sex").asText())
                    .numberPassport(node.get("numberPassport").asText())
                    .codePassport(node.get("codePassport").asText())
                    .build();
        }
    }

    private static class DestinationDeserializer extends JsonDeserializer<Destination> {

        @Override
        public Destination deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            JsonNode node = parser.getCodec().readTree(parser);

            return new Destination(node.get("from").asText(), node.get("to").asText());
        }
    }

    private static class TripDeserializer extends JsonDeserializer<Trip> {

        @Override
        public Trip deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectCodec codec = parser.getCodec();
            JsonNode node = codec.readTree(parser);

            List<User> users = new ArrayList<>();
            for (JsonNode userNode : node.get("users")) {
                users.add(codec.treeToValue(userNode, User.class));
            }

            Destination destination = codec.treeToValue(node.get("destination"), Destination.class);

            return new Trip(users, destination);
        }
    }

    private static void uploadDataToJson(List<Trip> trips) throws IOException {
        System.out.println("Запись в JSON...");
        createMapper().writeValue(new File("trips.json"), trips);
        System.out.println("Файл сохранён как trips.json");
    }

    private static List<Trip> downloadDataFromJson() throws IOException {
        System.out.println("Чтение из JSON...");
        List<Trip> trips = createMapper().readValue(new File("trips.json"), new TypeReference<List<Trip>>() {});
        System.out.println("Файл trips.json прочитан");
        return trips;
    }


    private static void printTrips(List<Trip> trips) {
        for (Trip trip : trips) {
            Destination destination = trip.getDestination();
            System.out.println("Поездка: " + destination.getFrom() + " -> " + destination.getTo());
            trip.getUsers().forEach(System.out::println);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Trip> trips = generateDataOfTrips();

        System.out.println("ИНФОРМАЦИЯ О ПОЕЗДКАХ: ");
        printTrips(trips);

        processSerialize(trips);
        List<Trip> restored = processDeserialize();

        System.out.println("ИНФОРМАЦИЯ О ПОЕЗДКАХ ПОСЛЕ ДЕСЕРИАЛИЗАЦИИ: ");
        printTrips(restored);

        uploadDataToJson(trips);
        List<Trip> fromJson = downloadDataFromJson();

        System.out.println("ИНФОРМАЦИЯ О ПОЕЗДКАХ ИЗ JSON: ");
        printTrips(fromJson);
    }
}
