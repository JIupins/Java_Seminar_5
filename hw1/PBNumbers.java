package hw1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PBNumbers {
    private Map<Integer, List<String>> dbNum = new HashMap<>();
    private Scanner iScan = new Scanner(System.in);

    public void addNumber(int key) {
        System.out.print("Введите номер телефона: ");
        String num = iScan.nextLine();

        if (dbNum.containsKey(key)) {
            List<String> list = dbNum.get(key);
            list.add(num);
        } else {
            List<String> list = new ArrayList<>();
            list.add(num);
            dbNum.put(key, list);
        }
    }

    public void delNumber(int key) {
        dbNum.remove(key);
    }

    public void showBaseNumbers() {
        for (List<String> i : dbNum.values()) {
            System.out.print(i);
        }
    }

    public String returnValue(int key) {
        String value = dbNum.get(key).toString();
        return value;
    }
}