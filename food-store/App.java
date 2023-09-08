import models.FoodItem;
import models.Restaurant;
import models.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Restaurant> restaurants = new ArrayList<>();
        Cart cart = new Cart();

        while (true) {
            clearConsole();
            System.out.println("Welcome to the Restaurant Management System!");
            System.out.println("\nHome Menu:");
            System.out.println("1. Create Restaurant");
            System.out.println("2. Add Food Item");
            System.out.println("3. List Menu Items");
            System.out.println("4. Add Food Item to Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    clearConsole();
                    System.out.println("Create a Restaurant:");
                    System.out.print("Enter restaurant name: ");
                    String restaurantName = scanner.nextLine();
                    Restaurant restaurant = new Restaurant(restaurantName);
                    restaurants.add(restaurant);
                    System.out.println("Restaurant '" + restaurantName + "' created.");
                    pauseExecution();
                    break;

                case 2:
                    clearConsole();
                    System.out.println("Add Food Item:");
                    if (restaurants.isEmpty()) {
                        System.out.println("No restaurants available. Please create a restaurant first.");
                        pauseExecution();
                        break;
                    }
                    System.out.println("Select a restaurant to add a food item:");
                    for (int i = 0; i < restaurants.size(); i++) {
                        System.out.println((i + 1) + ". " + restaurants.get(i).getName());
                    }
                    System.out.print("Enter your choice: ");
                    int restaurantChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (restaurantChoice >= 1 && restaurantChoice <= restaurants.size()) {
                        Restaurant selectedRestaurant = restaurants.get(restaurantChoice - 1);

                        System.out.print("Enter food item name: ");
                        String itemName = scanner.nextLine();
                        System.out.print("Enter food item price: ");
                        double itemPrice = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character

                        FoodItem foodItem = new FoodItem(selectedRestaurant.getMenu().size() + 1, itemName, itemPrice, selectedRestaurant);
                        System.out.println(itemName + " added to the menu of '" + selectedRestaurant.getName() + "'.");
                    } else {
                        System.out.println("Invalid restaurant choice.");
                    }
                    pauseExecution();
                    break;

                case 3:
                    clearConsole();
                    System.out.println("List Menu Items:");
                    if (restaurants.isEmpty()) {
                        System.out.println("No restaurants available. Please create a restaurant first.");
                    } else {
                        System.out.println("Select a restaurant to list menu items:");
                        for (int i = 0; i < restaurants.size(); i++) {
                            System.out.println((i + 1) + ". " + restaurants.get(i).getName());
                        }
                        System.out.print("Enter your choice: ");
                        int listChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        if (listChoice >= 1 && listChoice <= restaurants.size()) {
                            Restaurant selectedRestaurant = restaurants.get(listChoice - 1);
                            System.out.println("Menu Items for '" + selectedRestaurant.getName() + "':");
                            String menuItems = selectedRestaurant.getAllMenuItems();
                            System.out.println(menuItems);
                        } else {
                            System.out.println("Invalid restaurant choice.");
                        }
                    }
                    pauseExecution();
                    break;

                case 4:
                    clearConsole();
                    System.out.println("Add Food Item to Cart:");
                    if (restaurants.isEmpty()) {
                        System.out.println("No restaurants available. Please create a restaurant first.");
                        pauseExecution();
                        break;
                    }
                    System.out.println("Select a restaurant to add a food item to the cart:");
                    for (int i = 0; i < restaurants.size(); i++) {
                        System.out.println((i + 1) + ". " + restaurants.get(i).getName());
                    }
                    System.out.print("Enter your choice: ");
                    int cartRestaurantChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (cartRestaurantChoice >= 1 && cartRestaurantChoice <= restaurants.size()) {
                        Restaurant selectedRestaurant = restaurants.get(cartRestaurantChoice - 1);
                        System.out.println("Select a food item to add to the cart:");
                        String menuItems = selectedRestaurant.getAllMenuItems();
                        System.out.println(menuItems);

                        System.out.print("Enter the number of the food item to add to the cart: ");
                        int cartItemChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        if (cartItemChoice >= 1 && cartItemChoice <= selectedRestaurant.getMenu().size()) {
                            FoodItem selectedFoodItem = selectedRestaurant.getMenu().get(cartItemChoice - 1);
                            cart.addToCart(selectedFoodItem);
                            System.out.println(selectedFoodItem.getName() + " added to the cart.");
                        } else {
                            System.out.println("Invalid food item choice.");
                        }
                    } else {
                        System.out.println("Invalid restaurant choice.");
                    }
                    pauseExecution();
                    break;

                case 5:
                    clearConsole();
                    System.out.println("View Cart:");
                    System.out.println("Items in the cart:");
                    String cartItems = cart.toString();
                    if (cartItems.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        System.out.println(cartItems);
                    }
                    pauseExecution();
                    break;

                case 6:
                    clearConsole();
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    pauseExecution();
            }
        }
    }

    private static void clearConsole() {
        // Clears the console screen for improved user experience.
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void pauseExecution() {
        // Pauses execution and waits for user input to continue.
        System.out.print("Press Enter to continue...");
        new Scanner(System.in).nextLine();
    }
}
