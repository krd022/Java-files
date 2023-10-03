import java.util.*;

public class RestaurantMenu {
    
    public static void main(String[] args) {
        int totalOrders = 20; // Specify the total number of orders here

        // Create an array for each category (appetizers, entrees, desserts)
        String[] appetizers = {"Cactus Blossom", "Fried Pickles",  "Killer Ribs", "Lemon Pepper Steppers"};
        String[] entrees = {"Grilled Pork Chops", "Pulled Pork Chops", "Beef Tips", "Vegetable Plate", "Fried Sirloin"};
        String[] desserts = {"Granny`s Apple Classic", "Strawberry Cheesecake", "Big Ol` Brownie", "Peach Cobbler", "Cookie Crazy"};

        
        // Create a map to store menu item prices
        Map<String, Double> menuPrices = new HashMap<>();
        
        // Specify prices for each menu item
        menuPrices.put("Cactus Blossom", 7.99);
        menuPrices.put("Fried Pickles", 6.49);
        menuPrices.put("Rattlesnake Bites", 5.99);
        menuPrices.put("Killer Ribs", 8.99);
        menuPrices.put("Lemon Pepper Steppers", 7.49);

        menuPrices.put("Grilled Pork Chops", 15.99);
        menuPrices.put("Pulled Pork Chops", 14.49);
        menuPrices.put("Beef Tips", 16.99);
        menuPrices.put("Vegetable Plate", 18.49);
        menuPrices.put("Fried Sirloin", 19.99);

        menuPrices.put("Granny`s Apple Classic", 4.99);
        menuPrices.put("Strawberry Cheesecake", 5.49);
        menuPrices.put("Big Ol` Brownie", 6.99);
        menuPrices.put("Peach Cobbler", 3.99);
        menuPrices.put("Cookie Crazy", 4.49);

        // Display the menu
        displayMenu(appetizers, entrees, desserts, menuPrices);

        // array to store orders and initialize total money made
        List<String> orders = new ArrayList<>();
        double totalMoneyMade = 0.0d;

        // orders from the drive-thru
        for (int i = 0; i < totalOrders; i++) {
            String orderedItem = getRandomItem(appetizers, entrees, desserts);
            double itemPrice = menuPrices.get(orderedItem);
            totalMoneyMade += itemPrice;
            orders.add(orderedItem);
            System.out.println("Order #" + (i + 1) + ": " + orderedItem + " - $" + itemPrice);
        }

        // percentage of sales for each item
        Map<String, Integer> itemCounts = new HashMap<>();
        for (String item : orders) {
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }

        System.out.println("\nSummary:");
        System.out.println("Total money made: $" + String.format("%.2f", totalMoneyMade));

        System.out.println("Percentage of sales for each item:");
        for (String item : menuPrices.keySet()) {
            int count = itemCounts.getOrDefault(item, 0);
            double percentage = (count / (double) totalOrders) * 100.0; // Calculate percentage based on totalOrders
            System.out.println(item + ": " + percentage + "%");
        }

        System.out.println("\nList of items ordered with the number of times they're ordered:");
        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

   // Display the menu
   private static void displayMenu(String[] appetizers, String[] entrees, String[] desserts, Map<String, Double> menuPrices) {
    System.out.println("Menu:");

    System.out.println("Appetizers:");
    for (String appetizer : appetizers) {
        System.out.println(appetizer + " - $" + menuPrices.get(appetizer));
    }

    System.out.println("Entrees:");
    for (String entree : entrees) {
        System.out.println(entree + " - $" + menuPrices.get(entree));
    }

    System.out.println("Desserts:");
    for (String dessert : desserts) {
        System.out.println(dessert + " - $" + menuPrices.get(dessert));
    }

    System.out.println("\nPlease place your order." + "\nChoose one Item per vehicle.");
}

    // random item from the menu
    private static String getRandomItem(String[]... categories) {
        Random random = new Random();
        int categoryIndex = random.nextInt(categories.length);
        int itemIndex = random.nextInt(categories[categoryIndex].length);
        return categories[categoryIndex][itemIndex];
    }
}
