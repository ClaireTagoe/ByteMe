package edu.carleton.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.List;

import static edu.carleton.myapplication.MenuFinder.Get_WholeMenuList;

public class BurtonMenu extends AppCompatActivity {
    Intent intent = getIntent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burtonmenu);
    }

    public void onNewButtonClick(View view) {
        String s="";
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fis = openFileInput("BurtonWholeMenuDisplayMenu.txt");
            InputStreamReader InputRead= new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(InputRead);
            while ((s = br.readLine())!= null){
                sb.append(s);
                sb.append("0");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextView tv = (TextView)findViewById(R.id.burton_menu);
        tv.setText(sb.toString());
    }

}
