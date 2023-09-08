package models;

import java.util.List;
import java.util.ArrayList;


//Created a restaurant class with instance variables
public class Restaurant{
    private static int id;
    private String name;
    /* 
        This is an Arraylist of objects of type 'FoodItem'.
        As there is 1-many relationship from Restaurant to FoodItem
     */
    private List<FoodItem> menu; 
    
    //no-args Constructor for Restaurant
    public Restaurant(){
    /*
        Initialize menu field with new empty ArrayList.
        If not initialized then throws null pointer exception when we add
        food items to the list. 
    */
        this.menu = new ArrayList<>(); 
    }

    //all-args Constructor for Restaurant
    public Restaurant(String name){
        this.id++;
        this.name = name;
        this.menu = new ArrayList<>();
    }

    //Adding foodItems to the menu list
    public void addToMenu(FoodItem item){
        this.menu.add(item);
    }

    // Getter & Setter
    public List<FoodItem> getMenu(){
        return this.menu;
    }

    public String getName(){
        return this.name;
    }
     
    public String getAllMenuItems(){
        String ret = "\n";
        for(FoodItem item: menu){
            ret += item.getId()+"."+item.getName() + "\n";
        }
        return ret;
    }

    public String toString(){
        return this.name;
    }
}