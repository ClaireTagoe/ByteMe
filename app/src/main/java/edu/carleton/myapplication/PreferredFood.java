package edu.carleton.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;;

/**
 * Created by Survivor on 2016/4/9.
 */
public class PreferredFood extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_preferred);
    }

    public void onButtonClick(View button){

    }
}
