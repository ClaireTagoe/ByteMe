package edu.carleton.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;;import java.util.ArrayList;
import java.util.List;

/**
 * Created by Survivor on 2016/4/9.
 */
public class PreferredFood extends Activity{

    EditText editText;
    ListView lv;
    ArrayAdapter<String> aa;
    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_preferred);
        editText = (EditText)findViewById(R.id.editText);
    }

    public void onButtonClick(View view){
        this.addPreferredFood(editText);
        this.showFood();
        this.editText.setText("");
    }

    public void addPreferredFood(EditText editText){
        FoodList.food.add(editText.getText().toString());
    }

    public void showFood(){
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(FoodList.food.toString());

    }
}
