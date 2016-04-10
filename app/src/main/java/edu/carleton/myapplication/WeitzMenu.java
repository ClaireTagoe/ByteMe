package edu.carleton.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WeitzMenu extends AppCompatActivity {
    Intent intent = getIntent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weitzmenu);
        TextView tv = (TextView)findViewById(R.id.weitz_menu);
        InputStream in = null;
        try {
            in = getApplicationContext().getAssets().open("weitz_menu.txt");
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
        }
    }
}
