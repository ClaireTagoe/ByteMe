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

    List<String> foodList;
    EditText editText;
    ListView lv;
    ArrayAdapter<String> aa;
    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_preferred);
        foodList =  new ArrayList<String>();
        editText = (EditText)findViewById(R.id.editText);
        lv = (ListView)findViewById(R.id.listView);
    }

    public void onButtonClick(View view){
        this.addPreferredFood(editText);
        this.showFood();
    }

    public void addPreferredFood(EditText editText){
        foodList.add(editText.getText().toString());
    }

    public void showFood(){
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(foodList.toString());

    }
}
