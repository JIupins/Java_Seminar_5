package hw1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PBNames {
    private Map<Integer, String> dbName = new HashMap<>();
    private Scanner iScan = new Scanner(System.in);

    public void addPeople(int key, String fio) {
        dbName.put(key, fio);
    }

    public int delPeople() {
        int key = -1;
        System.out.print("Введите ФИО человека: ");
        String fio = iScan.nextLine();

        for (Map.Entry<Integer, String> entry : dbName.entrySet()) {
            if (fio.equals(entry.getValue())) {
                key = entry.getKey();
                dbName.remove(key);
                break;
            }
        }
        return key;
    }

    public void showBasePeoples() {
        for (String i : dbName.values()) {
            System.out.print(i);
        }
        System.out.println();
    }

    public String returnValue(int key) {
        String value = dbName.get(key);
        return value;
    }

    public Integer getLength() {
        return Collections.max(dbName.keySet());
    }

    public boolean containedValuedAtList(String fio) {
        if (dbName.containsValue(fio)) {
            return true;
        } else {
            return false;
        }
    }

    public int containedKeyAtList(String fio) {
        int key;
        for (Map.Entry<Integer, String> entry : dbName.entrySet()) {
            if (fio.equals(entry.getValue())) {
                key = entry.getKey();
                return key;
            }
        }
        return key = -1;
    }
}