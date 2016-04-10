package edu.carleton.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Ruyi on 4/9/16.
 */
public class NotificationService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        mTimer = new Timer();
//        Date StartDate =  new Date();
//        StartDate.setHours(4);
//        mTimer.schedule(timerTask, StartDate,24*60*60*1000);
        mTimer.schedule(timerTask, 2000, 10*1000);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
        return super.onStartCommand(intent,flags,startId);
    }

    private Timer mTimer;

    TimerTask timerTask = new TimerTask() {

        @Override
        public void run(){
            Log.e("Log","Running");
            notifiiy();
        }
    };


    public void onDestroy() {
        try{
            mTimer.cancel();
            timerTask.cancel();
        }catch (Exception e){
            e.printStackTrace();
        }

        Intent intent = new Intent("edu.carleton.myapplication");
        intent.putExtra("yourvalue","torestore");
        sendBroadcast(intent);
    }

//    public void notifiy(){
//
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("RSSPullService");
//
//        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//        PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(), 0, myIntent, Intent.FLAG_ACTIVITY_NEW_TASK);
//        Context context = getApplicationContext();
//
//        Notification.Builder builder;
//
//            builder = new Notification.Builder(context)
//                        .setContentTitle("T")
//                        .setContentText("M")
//                        .setContentIntent(pendingIntent)
//                        .setDefaults(Notification.DEFAULT_SOUND)
//                        .setAutoCancel(true)
//                        .setSmallIcon(R.mipmap.ic_launcher);
//
////        Notification notification = builder.build();
//
//        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(1,builder,build());
//}

    public void notifiiy(){

        String FavouriteDish = "Omlet";
        String Place = "LDC";
        NotificationCompat.Builder mBuilder =

                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Byte me")
                        .setContentText("Your favourite " + FavouriteDish + " is in " + Place + ".\n Click for more!" );
// Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, PreferredFood.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(PreferredFood.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(1, mBuilder.build());



    }
}
