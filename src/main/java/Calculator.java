import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    ArrayList<Product> products = new ArrayList<>();
    int numberOfPeople;
    private double totalCost;
    Scanner scanner = new Scanner(System.in);
    Formatter formatter = new Formatter();

    public void addItem(Product product) {
        totalCost += product.getPrice();
        products.add(product);
    }

    public void showSummary() {
        System.out.println("Список добавленных товаров:");
        double totalCost = 0;

        for (Product product : products) {
            System.out.println("- " + product.getName());
            totalCost += product.getPrice();
        }

        System.out.println("Общая стоимость: " + totalCost + " руб.");
        System.out.println("Сумма, которую должен заплатить каждый человек: " + formatter.formatTotalCost(totalCost, numberOfPeople));
    }

    public void action() {
        while (true) {
            System.out.print("Введите название товара (или 'Завершить' для завершения): ");
            String productName = scanner.next().trim();

            if (productName.equalsIgnoreCase("Завершить")) {
                break;
            }

            System.out.print("Введите стоимость товара (в формате рубли.копейки): ");
            double productCost;

            if (scanner.hasNextDouble()) {
                productCost = scanner.nextDouble();
                addItem(new Product(productName, productCost));
                System.out.println("Товар успешно добавлен!");

                System.out.print("Хотите добавить ещё один товар? (да/нет): ");
                String answer = scanner.next().trim();
                if (!answer.equalsIgnoreCase("да")) {
                    break;
                }
            } else {
                System.out.println("Некорректный формат стоимости товара. Пожалуйста, введите число.");
                scanner.next(); // Очищаем буфер ввода
            }
        }
        showSummary();
    }

    public Calculator(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}