import models.FoodItem;
import models.Restaurant;

public class App{
    public static void main(String args[]){

        // 1. Create a restaurant
        Restaurant mcDonalds = new Restaurant(1,"McDonalds");

        // 2. Add 3 food items to created restaurant
        FoodItem frenchFries = new FoodItem(1,"French Fries",3.99,mcDonalds);
        FoodItem burger = new FoodItem(2,"Burger",2.99,mcDonalds);
        FoodItem dietCoke = new FoodItem(3,"Diet Coke",1.99,mcDonalds);
        
        // 3. Add 2 food items to cart
        // 4. Place an order
    }
}