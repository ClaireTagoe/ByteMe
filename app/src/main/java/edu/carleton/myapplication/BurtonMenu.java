package edu.carleton.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import static edu.carleton.myapplication.MenuFinder.Get_WholeMenuList;

public class BurtonMenu extends AppCompatActivity {
    Intent intent = getIntent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burtonmenu);
        TextView tv = (TextView)findViewById(R.id.burton_menu);
        InputStream in = null;
        try {
            in = getApplicationContext().getAssets().open("burton_menu.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (in != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder out = new StringBuilder();
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    out.append(line);
                    out.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert tv != null;
            tv.setText(out.toString());
////        tv.setText("Brunch\n" +
//                "-------------------------------------------------------\n" +
//                "Corn Chowder (↓G)\n" +
//                "Steak and Potato (↓G)\n" +
//                "Cage Free Scrambled Eggs (V) (↓G)\n" +
//                "Cage Free Scrambled Eggs with Cheese (V) (↓G)\n" +
//                "Turkey Sausage (↓G)\n" +
//                "Rope Sausage (↓G)\n" +
//                "Vegetable Sausage (V)\n" +
//                "Hashbrowns (VG) (↓G)\n" +
//                "French Toast (V)\n" +
//                "Grilled Chicken Breast (↓G)\n" +
//                "Lentil Burger (VG)\n" +
//                "\"Ferndale Market\" Turkey Pasta Bake with Sundried Tomato (F2F)\n" +
//                "Pork Sausage Breakfast Bake\n" +
//                "Sauteed Mushrooms and Onions (VG) (↓G)\n" +
//                "Chorizo Sausage and Bell Peppers\n" +
//                "Cream and Spinach (V)\n" +
//                "\"Hasting Dairy Co-Op\" Provolone and Mozzarella (V) (LC)\n" +
//                "Made Without Gluten Pizza Available upon Request\n" +
//                "Pasta (VG)\n" +
//                "Marinara  (VG) (↓G)\n" +
//                "\"Hasting Dairy Co-Op\" Alfredo (V) (LC)\n" +
//                "Steamed Carrots and Peas (VG) (↓G)\n" +
//                "\n" +
//                "Dinner\n" +
//                "-------------------------------------------------------\n" +
//                "Corn Chowder (↓G)\n" +
//                "Steak and Potato (↓G)\n" +
//                "Pesto Roasted Chicken Pasta Bake with Alfredo\n" +
//                "Herb Roasted Yellow Squash (VG) (↓G)\n" +
//                "Spring Inspired Salad Tossed with Green Olive Vinaigrette (VG) (↓G)\n" +
//                "Grilled Chicken Breast (↓G)\n" +
//                "Lentil Burger (VG)\n" +
//                "\"Ferndale Market\" Turkey Pasta Bake with Sundried Tomato (F2F)\n" +
//                "Pork Sausage Breakfast Bake\n" +
//                "Sauteed Mushrooms and Onions (VG) (↓G)\n" +
//                "Chorizo Sausage and Bell Peppers\n" +
//                "Cream and Spinach (V)\n" +
//                "\"Hasting Dairy Co-Op\" Provolone and Mozzarella (V) (LC)\n" +
//                "Made Without Gluten Pizza Available upon Request\n" +
//                "Pasta (VG)\n" +
//                "Marinara  (VG) (↓G)\n" +
//                "\"Hasting Dairy Co-Op\" Alfredo (V) (LC)\n" +
//                "Steamed Carrots and Peas (VG) (↓G)\n" +
//                "Pork Vindaloo (↓G)\n" +
//                "Saffron and Cardamom Spice Rice Pilaf (VG) (↓G)\n" +
//                "Sautéed Chickpeas with Cinnamon and Ginger (VG) (↓G)\n" +
//                "\n");

        }
     }

     //Try refresh fetching data
   // public void onNewButtonClick(View view) {
//        String s="";
//        StringBuilder sb = new StringBuilder();
//        try {
//            FileInputStream fis = openFileInput("BurtonWholeMenuDisplayMenu.txt");
//            InputStreamReader InputRead= new InputStreamReader(fis);
//            BufferedReader br = new BufferedReader(InputRead);
//            while ((s = br.readLine())!= null){
//                sb.append(s);
//                sb.append("0");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        TextView tv = (TextView)findViewById(R.id.burton_menu);
//        tv.setText(sb.toString());
//    }

}
