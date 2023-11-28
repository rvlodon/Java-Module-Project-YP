public class Formatter {
    public static String formatTotalCost(double totalCost, int numberOfPeople) {
        double costPerPerson = totalCost / numberOfPeople;
        int rubles = (int) Math.floor(costPerPerson);
        int kopecks = (int) Math.round((costPerPerson - rubles) * 100);

        String formattedCost = String.valueOf((int) Math.floor(costPerPerson));
        formattedCost += " ";

        if (rubles % 100 >= 11 && rubles % 100 <= 19) {
            formattedCost += "рублей";
        } else {
            switch (rubles % 10) {
                case 1:
                    formattedCost += "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    formattedCost += "рубля";
                    break;
                default:
                    formattedCost += "рублей";
            }
        }

        if (kopecks != 0) {
            formattedCost += " " + kopecks + " копеек";
        }

        return formattedCost;
    }
}