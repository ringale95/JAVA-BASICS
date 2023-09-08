package models;

import java.util.List;
import java.util.ArrayList;

public class Restaurant{
    private int id;
    private String name;
    private List<FoodItem> menu;

    public Restaurant(){
        this.menu = new ArrayList<>();
    }

    public Restaurant(int id,String name){
        this.id = id;
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public void addToMenu(FoodItem item){
        this.menu.add(item);
    }

    public List<FoodItem> getMenu(){
        return this.menu;
    }

    public String getName(){
        return this.name;
    }
    
    public String toString(){
        return this.name;
    }

    public String getAllMenuItems(){
        String ret = "\n";
        for(FoodItem item: menu){
            ret += item.getName() + "\n";
        }
        return ret;
    }
}