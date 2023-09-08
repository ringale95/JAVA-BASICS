package models;

public class FoodItem{
    private static int id;
    private String name;
    private double price;
    private Restaurant restaurant;

    public FoodItem(){}

    public FoodItem(int id,String name,double price,Restaurant restaurant){
        this.id++;
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
        this.restaurant.addToMenu(this); 
    }

    // Getter & Setter
    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public double getPrice(){
        return this.price;
    }

    // toString
    public String toString(){
        return "\nid: "+this.id+"\nname: "+this.name+"\nprice: "+this.price+"\nRestaurant: "+this.restaurant+"\n";
    }
}