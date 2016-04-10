package edu.carleton.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Try fetching data on Main Thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
//        try {
//            MenuFinder.menuSync(getApplicationContext());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//         //Try using a new Thread
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    MenuFinder.menuSync(getApplicationContext());
//                    Log.i("END", "End");
//                } catch (MalformedURLException e) {
//                    Log.d("MFUE", "MFUE");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        thread.start();

        startService(new Intent(this,NotificationService.class));
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void onButtonClick(View view) {
        //do something when button is clicked.
        Intent intent = new Intent(this, PreferredFood.class);
        startActivity(intent);

    }

    public void onFoodClick(View view) {
        //do something when button is clicked.
        Intent intent = new Intent(this, MyFood.class);
        startActivity(intent);

    }
    public void onSettingClick(View view) {
        //do something when button is clicked.
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

    }
    public void onLDCClick(View view) {
        //do something when button is clicked.
        Intent intent = new Intent(this, LDCMenu.class);
        startActivity(intent);
    }
    public void onBurtonClick(View view) {
        //do something when button is clicked.
//        try {
//            MenuFinder.menuSync(getApplicationContext());
//            Log.i("END", "End");
//        } catch (MalformedURLException e) {
//            Log.d("MFUE", "MFUE");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Intent intent = new Intent(this, BurtonMenu.class);
        startActivity(intent);
    }
    public void onSaylesClick(View view) {
        //do something when button is clicked.
        Intent intent = new Intent(this, SaylesMenu.class);
        startActivity(intent);
    }
    public void onWeitzClick(View view) {
        //do something when button is clicked.
        Intent intent = new Intent(this, WeitzMenu.class);
        startActivity(intent);
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://edu.carleton.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://edu.carleton.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
