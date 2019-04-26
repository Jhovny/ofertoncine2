package com.tarwisoft.ofertoncine2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tarwisoft.ofertoncine2.model.CineNotificacion;

public class SDSFirebaseMessagingService extends FirebaseMessagingService {


    private static final String KEY_DESCONT ="descount_key";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);
        String TAG="GET MENSAJE";
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        CineNotificacion cineNotificacion= new CineNotificacion();
        cineNotificacion.setId(remoteMessage.getFrom());
        cineNotificacion.setTitle(remoteMessage.getNotification().getTitle());
        cineNotificacion.setDescripcion(remoteMessage.getNotification().getBody());
        cineNotificacion.setDescount(remoteMessage.getData().get(KEY_DESCONT));
        showNotification(cineNotificacion);
    }

    private void showNotification(CineNotificacion cineNotificacion){

        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=
                PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        Uri deFaultSounduri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder=new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_video_label_black_cine_24dp)
                .setContentTitle(cineNotificacion.getTitle())
                .setContentText(cineNotificacion.getDescount())
                .setAutoCancel(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setSound(deFaultSounduri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0,notificationBuilder.build());
    }

}
