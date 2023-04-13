package hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PhoneBook {
    private PBNames pbName = new PBNames();
    private PBNumbers pbNumber = new PBNumbers();
    private ArrayList<Integer> keys = new ArrayList<>();
    private Integer curentKey;

    public void addHuman() {
        int newKey = generateKey();
        int key;

        Scanner iScan = new Scanner(System.in);
        System.out.print("Введите ФИО человека: ");
        String fio = iScan.nextLine();

        if (pbName.containedValuedAtList(fio)) {
            key = pbName.containedKeyAtList(fio);
            pbNumber.addNumber(key);
        } else {
            key = newKey;
            pbName.addPeople(key, fio);
            pbNumber.addNumber(key);
        }
    }

    public void delHuman() {
        int key = pbName.delPeople();

        if (key < 0) {
            System.out.println("Такого человека в базе нет!");
        } else {
            pbNumber.delNumber(key);
            keys.remove(keys.indexOf(key));
            curentKey = key;
            System.out.printf("Key %d = CurentKey %d\n", key, curentKey);
        }
    }

    public void showBook() {
        int length = pbName.getLength();

        for (int i = 0; i <= length; i++) {
            if (pbName.returnValue(i) != null) {
                System.out.printf("ФИО: %s --- Телефон: %s.\n", pbName.returnValue(i), pbNumber.returnValue(i));
            }
        }
    }

    public void showBookSep() {
        pbName.showBasePeoples();
        pbNumber.showBaseNumbers();
    }

    private Integer generateKey() {
        Collections.sort(keys);

        if (keys.isEmpty()) {
            curentKey = 0;
            keys.add(curentKey);
            return curentKey++;
        } else if (keys.contains(curentKey)) {
            boolean flag = true;
            curentKey = 0;
            while (flag) {
                if (keys.contains(curentKey)) {
                    curentKey++;
                } else {
                    flag = false;
                }
            }
            keys.add(curentKey);
            return curentKey++;
        } else {
            keys.add(curentKey);
            return curentKey++;
        }
    }
}