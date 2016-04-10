package edu.carleton.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class BurtonMenu extends AppCompatActivity {
    Intent intent = getIntent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burtonmenu);
        TextView textView = (TextView)findViewById(R.id.burton_menu);
        textView.setText(readMenu());
    }

    public String readMenu(){
        String s="";
        try {
            FileInputStream fis = openFileInput("BurtonWholeMenuDisplayMenu.txt");
            InputStreamReader InputRead= new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(InputRead);
            StringBuilder sb = new StringBuilder();
            while ((s = br.readLine())!= null){
                sb.append(s);
                sb.append("0");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

}
