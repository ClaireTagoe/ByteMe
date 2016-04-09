package edu.carleton.myapplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Survivor on 2016/4/9.
 */
public class FoodList {
    public static Set<String> food = new HashSet<String>();

    public void add(String foodName){
        food.add(foodName);
    }

    public void remove(String foodName){
        food.remove(foodName);
    }
}
