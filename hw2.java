// Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов,
// Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
// Для сортировки использовать TreeMap.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class hw2 {
    public static void main(String[] args) {
        String mainList1 = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, "
                + "Мария Федорова, Марина Светлова, Мария Савина, Светлана Петрова, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.";

        List<String> mainList2 = new ArrayList<>();
        mainList2 = prepareData(mainList1);

        TreeMap<String, Integer> mainMap = new TreeMap<>();
        mainMap = findRepeats(mainList2);

        sortMap(mainMap);
    }

    public static List<String> prepareData(String str) {
        ArrayList<String> list1 = new ArrayList<>();
        String[] list2 = str.replace(".", "").split(", ");

        for (String i : list2) {
            list1.add(i.substring(0, i.indexOf(" ")));
        }
        return list1;
    }

    public static TreeMap<String, Integer> findRepeats(List<String> list) {
        TreeMap<String, Integer> tMap = new TreeMap<>();

        for (String item : list) {
            Integer count = tMap.get(item);
            tMap.put(item, (count == null) ? 1 : count + 1);
        }
        return tMap;
    }

    public static void sortMap(TreeMap<String, Integer> trMap) {
        TreeMap<Integer, List<String>> nMap = new TreeMap<>(Comparator.reverseOrder());

        for (var item : trMap.entrySet()) {
            if (nMap.containsKey(item.getValue())) {
                List<String> list = nMap.get(item.getValue());
                list.add(item.getKey());
            } else {
                List<String> list = new ArrayList<>();
                list.add(item.getKey());
                nMap.put(item.getValue(), list);
            }
        }
        System.out.println(nMap.toString());
    }
}