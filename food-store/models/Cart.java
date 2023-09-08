package models;

import java.util.*;

public class Cart{
    private List<FoodItem> items;
    private double totalPrice;

    public Cart(){
        this.items = new ArrayList<>();
    }

    public void addToCart(FoodItem item){
        this.items.add(item);
    }

    public String toString(){
        String ret = "";
        for(FoodItem item: items){
            ret += item.getName() + " - "+item.getPrice()+"\n";
        }
        return ret;
    }
}

