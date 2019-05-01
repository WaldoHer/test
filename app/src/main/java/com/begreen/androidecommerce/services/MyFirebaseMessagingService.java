package com.begreen.androidecommerce.services;

import android.content.Intent;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import com.begreen.androidecommerce.activities.SplashScreen;
import com.begreen.androidecommerce.utils.NotificationHelper;


/**
 * MyFirebaseMessagingService receives notification Firebase Cloud Messaging Server
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    
    
    //*********** Called when the Notification is Received ********//
    
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Intent notificationIntent = new Intent(getApplicationContext(), SplashScreen.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        NotificationHelper.showNewNotification
                (
                        getApplicationContext(),
                        notificationIntent,
                        remoteMessage.getData().get("title"),
                        remoteMessage.getData().get("message")
                );
        
    }
    
}
