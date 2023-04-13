// Реализовать алгоритм пирамидальной сортировки (HeapSort)

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {
        int size = createNumber("Введите колличество элементов в списке: ");
        int max = createNumber("Введите максимальное значение элементов в списке: ");

        int[] array = createArray(size, max);

        System.out.println(Arrays.toString(array));
        int[] res = Sorted(array);
        System.out.println(Arrays.toString(res));
    }

    public static Integer createNumber(String frase) {
        Scanner iScan = new Scanner(System.in);
        System.out.printf("\n%s", frase);
        int num = iScan.nextInt();
        return num;
    }

    static int[] createArray(int size, int max) {
        int[] array = new int[size];
        Random item = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = item.nextInt(max + 1);
        }
        return array;
    }

    static int[] Sorted(int[] array) {
        if (array.length == 0) {
            return array;
        }

        int len = array.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            array = buildStructure(array, len, i);
        }

        for (int i = len - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            array = buildStructure(array, i, 0);
        }
        return array;
    }

    static int[] buildStructure(int[] array, int len, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int max = i;

        if (leftChild < len && array[leftChild] > array[max]) {
            max = leftChild;
        }

        if (rightChild < len && array[rightChild] > array[max]) {
            max = rightChild;
        }

        if (max != i) {
            int temp = array[i];
            array[i] = array[max];
            array[max] = temp;

            array = buildStructure(array, len, max);
        }
        return array;
    }
}