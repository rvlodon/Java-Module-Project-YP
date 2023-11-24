import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberPeople;

        while (true) {
            System.out.println("На сколько человек разделить счет?");

            if (scanner.hasNextInt()) {
                numberPeople = scanner.nextInt();

                if (numberPeople <= 1) {
                    System.out.println("Ошибка, количество гостей должно быть больше 1");
                } else {
                    break;
                }
            } else {
                System.out.println("Ошибка ввода. Введите целое число.");
                scanner.next();
            }
        }

        Calculator calculator = new Calculator(numberPeople);
        calculator.action();

        scanner.close();
    }
}