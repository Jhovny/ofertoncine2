package com.tarwisoft.ofertoncine2;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class SDSFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);
        String TAG="Prueba";
        Log.d(TAG, "From: " + remoteMessage.getFrom());

    }
}
