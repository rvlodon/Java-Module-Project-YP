import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class Calculator {
    private ArrayList<Product> products = new ArrayList<>();
    private int numberOfPeople;
    private Scanner scanner = new Scanner(System.in);
    private Formatter formatter = new Formatter();

    private void addItem(Product product) {
        products.add(product);
    }

    private void showSummary() {
        System.out.println("Список добавленных товаров:");
        double totalCost = 0;

        for (Product product : products) {
            System.out.println("- " + product.getName());
            totalCost += product.getPrice();
        }

        System.out.println("Общая стоимость: " + totalCost + " руб.");
        System.out.println("Сумма, которую должен заплатить каждый человек: " + formatter.formatTotalCost(totalCost, numberOfPeople));
    }

    void action() {
        while (true) {
            System.out.print("Введите название товара (или 'Завершить' для завершения): ");
            String productName = scanner.nextLine().trim();

            if (productName.equalsIgnoreCase("Завершить")) {
                break;
            }

            double productCost;

            while (true) {
                System.out.print("Введите стоимость товара (в формате рубли.копейки): ");

                try {
                    productCost = Double.parseDouble(scanner.nextLine());
                    if (productCost > 0) {
                        break;
                    } else {
                        System.out.println("Введите положительное число");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный формат стоимости товара. Пожалуйста, введите число (в формате рубли.копейки).");
                }
            }

            addItem(new Product(productName, productCost));
            System.out.println("Товар успешно добавлен!");

            while (true) {
                System.out.print("Хотите добавить ещё один товар? (да/нет): ");
                String answer = scanner.next().trim();
                if (answer.equalsIgnoreCase("да")) {
                    scanner.nextLine();
                    break;
                } else if (answer.equalsIgnoreCase("нет")) {
                    showSummary();
                    return;
                } else {
                    System.out.println("Некорректный ввод. Введите только 'да' или 'нет'.");
                }
            }
        }
    }

    public Calculator(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}