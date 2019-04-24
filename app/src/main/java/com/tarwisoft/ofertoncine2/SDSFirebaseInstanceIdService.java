package com.tarwisoft.ofertoncine2;


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;

public class SDSFirebaseInstanceIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh (){
        super.onTokenRefresh();

        String token= FirebaseInstanceId.getInstance().getToken();
        Log.w("TAG", "TokenRefresh" + token);
    }

}