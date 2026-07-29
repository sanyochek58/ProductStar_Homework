import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        RankingSystem rankingSystem = new RankingSystem();

        Player alice = new Player(1, "Alice", 1500);
        Player bob = new Player(2, "Bob", 1400);
        Player charlie = new Player(3, "Charlie", 1550);

        rankingSystem.addPlayer(alice);
        System.out.println("Добавлен игрок: " + alice.getName() + " (ID: " + alice.getId() + ", Рейтинг: " + alice.getRating() + ")");

        rankingSystem.addPlayer(bob);
        System.out.println("Добавлен игрок: " + bob.getName() + " (ID: " + bob.getId() + ", Рейтинг: " + bob.getRating() + ")");

        rankingSystem.addPlayer(charlie);
        System.out.println("Добавлен игрок: " + charlie.getName() + " (ID: " + charlie.getId() + ", Рейтинг: " + charlie.getRating() + ")");

        System.out.println();
        printTopPlayers(rankingSystem, 3, "Топ 3 игрока:");

        System.out.println();
        rankingSystem.updatePlayerRating(bob.getId(), 1600);
        System.out.println("Обновлен рейтинг игрока " + bob.getName() + ": " + bob.getRating());

        System.out.println();
        printTopPlayers(rankingSystem, 3, "Топ 3 игрока после обновления:");

        System.out.println();
        int aliceRank = rankingSystem.getPlayerRank(alice.getId());
        System.out.println("Текущий ранг " + alice.getName() + ": " + aliceRank);

        System.out.println();
        System.out.println("Попытка получить ранг несуществующего игрока:");
        try {
            rankingSystem.getPlayerRank(4);
        } catch (PlayerNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Попытка получить топ-5 игроков при наличии только 3 игроков:");
        try {
            rankingSystem.getTopPlayers(5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void printTopPlayers(RankingSystem rankingSystem, int n, String title) {
        System.out.println(title);
        List<Player> topPlayers = rankingSystem.getTopPlayers(n);
        for (int i = 0; i < topPlayers.size(); i++) {
            Player player = topPlayers.get(i);
            System.out.println((i + 1) + ". " + player.getName() + " - " + player.getRating());
        }
    }
}
