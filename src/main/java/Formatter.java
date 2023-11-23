public class Formatter {
    public static String formatTotalCost(double totalCost, int numberOfPeople) {
        double costPerPerson = totalCost / numberOfPeople;
        int rubles = (int) Math.floor(costPerPerson);
        int kopecks = (int) Math.round((costPerPerson - rubles) * 100);

        String formattedCost = String.valueOf((int) Math.floor(costPerPerson));
        formattedCost += " руб";

        if (rubles != 1) {
            formattedCost += "лей";
        }

        if (kopecks != 0) {
            formattedCost += " " + kopecks + " копеек";
        }

        return formattedCost;
    }
}