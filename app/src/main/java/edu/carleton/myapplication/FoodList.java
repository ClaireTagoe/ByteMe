package edu.carleton.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Survivor on 2016/4/9.
 */
public class FoodList {
    public static List<String> food = new ArrayList<String>();

    public void add(String foodName){
        food.add(foodName);
    }

    public void remove(String foodName){

    }
}
