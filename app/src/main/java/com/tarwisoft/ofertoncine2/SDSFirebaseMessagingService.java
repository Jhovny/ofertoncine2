package com.tarwisoft.ofertoncine2;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class SDSFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);
        String TAG="GET MENSAJE";
        Log.d(TAG, "From: " + remoteMessage.getFrom());

    }

    @Override
    public void onNewToken (String s){
        super.onNewToken(s);


        Log.w("TAG", "TokenRefresh: " + s);
    }

}
