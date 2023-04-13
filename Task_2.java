import java.util.*;

/*
 * 2. Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин,
Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина,
Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
Для сортиорвки использовать TreeMap.
 */

public class Task_2 {
    public static void main(String[] args) {
        String userInput = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, \n" +
                "Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, \n" +
                "Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";

        List<String> inputList = new ArrayList<String>(Arrays.asList(userInput.split("\\s*(,|\n)\\s*")));
        HashMap<String, Integer> names = new HashMap<>();
        TreeMap<Integer, List<String>> sortedNames1 = new TreeMap<>(Comparator.reverseOrder());

        for (String person : inputList) {
            String temp = person.split(" ")[0];
            if (names.containsKey(temp)) {
                names.compute(temp, (k, v) -> v += 1);
            } else {
                names.put(temp, 1);
            }
        }

        for (var item : names.entrySet()) {
            if (sortedNames1.containsKey(item.getValue())) {
                List<String> list = sortedNames1.get(item.getValue());
                list.add(item.getKey());
            } else {
                List<String> list = new ArrayList<>();
                list.add(item.getKey());
                sortedNames1.put(item.getValue(), list);
            }
        }

        System.out.println(names);
        // List<Map.Entry<String, Integer>> sortedNames = new
        // ArrayList<>(names.entrySet());
        // sortedNames.sort(Map.Entry.comparingByValue(Comparator.reverseOrder())); *
        // Оставила для себя
        System.out.println(sortedNames1);
    }
}