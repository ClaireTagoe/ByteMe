package edu.carleton.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Ruyi on 4/9/16.
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        Log.i("Service Stops","Ohhhh");
        context.startService(new Intent(context, NotificationService.class));
    }
}
