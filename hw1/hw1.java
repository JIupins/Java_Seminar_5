// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

package hw1;

import java.util.Scanner;

public class hw1 {

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();

        Scanner iScan = new Scanner(System.in);
        String sign;

        Boolean flag = true;

        while (flag) {
            System.out.println("\nДоступны следующие операции:\n" +
                    "+ _ добавить информацию в справочник\n" +
                    "- _ удалить информацию из справочника\n" +
                    "S _ вывести информацию из справочника\n" +
                    "Q _ выйти из программы\n");
            System.out.print("Введите символ операции: ");
            sign = iScan.nextLine();

            switch (sign) {
                case "+":
                    pb.addHuman();
                    break;
                case "-":
                    pb.delHuman();
                    break;
                case "S":
                    pb.showBook();
                    break;
                case "Q":
                    flag = false;
                    break;
                case "=":
                    pb.showBookSep();
                    break;
                default:
                    System.out.println("Символ введен неверно! Повторите ввод.");
                    break;
            }
        }
    }
}
