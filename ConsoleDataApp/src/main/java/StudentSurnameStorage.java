import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentSurnameStorage {

    private TreeMap<String, Set<Long>> surnamesTreeMap = new TreeMap<>();


    public void studentCreated(Long id, String surname){
        Set<Long> existingIds = surnamesTreeMap.getOrDefault(surname, new HashSet<>());
        existingIds.add(id);
        surnamesTreeMap.put(surname, existingIds);
    }

    public void studentDeleted(Long id, String surname){
        surnamesTreeMap.get(surname).remove(id);
    }

    public void studentUpdated(Long id, String oldSurname, String newSurname){
        studentDeleted(id, oldSurname);
        studentCreated(id, newSurname);
    }

    /**
     * Возвращает уникальные идентификаторы студентов с фамилией, точно совпадающей с переданной
     * @param surname фамилия студента
     * @return set
     */
    public Set<Long> getStudentsBySurname(String surname){
        return new HashSet<>(surnamesTreeMap.getOrDefault(surname, Collections.emptySet()));
    }

    /**
     * Возвращает уникальные идентификаторы студентов, чьи фамилии в алфавитном порядке
     * находятся в диапазоне [fromSurname; toSurname] включительно
     * @param fromSurname нижняя граница диапазона
     * @param toSurname верхняя граница диапазона
     * @return set
     */
    public Set<Long> getStudentsBySurnameRange(String fromSurname, String toSurname){
        String from = fromSurname;
        String to = toSurname;
        if(from.compareTo(to) > 0){
            String tmp = from;
            from = to;
            to = tmp;
        }
        return surnamesTreeMap.subMap(from, true, to, true).values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    /**
     * Возвращает уникальные идентификаторы всех студентов
     * @return set
     */
    public Set<Long> getAllStudentIds(){
        return surnamesTreeMap.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public TreeMap<String, Set<Long>> getSurnamesTreeMap() {
        return surnamesTreeMap;
    }

    public void setSurnamesTreeMap(TreeMap<String, Set<Long>> surnamesTreeMap) {
        this.surnamesTreeMap = surnamesTreeMap;
    }
}
