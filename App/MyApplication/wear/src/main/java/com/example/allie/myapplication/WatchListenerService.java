package com.example.allie.myapplication;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import java.nio.charset.StandardCharsets;

/**
 * Created by allie on 3/2/16.
 */
public class WatchListenerService extends WearableListenerService {
    private static final String ZIP_CODE = "/zipCode";
    private static final String CURRLOCATION = "/currentLocation";

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Log.d("T", "in WatchListenerService, got: " + messageEvent.getPath());

        if( messageEvent.getPath().equalsIgnoreCase( ZIP_CODE ) ) {
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);
            Intent intent = new Intent(this, MainActivity.class );
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //you need to add this flag since you're starting a new activity from a service
            intent.putExtra("Come_From","ZIP_Code");
            Log.d("T", "about to start watch MainActivity from ZipCode");
            startActivity(intent);
        } else if (messageEvent.getPath().equalsIgnoreCase(CURRLOCATION)) {
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);
            Intent intent = new Intent(this, MainActivity.class );
            intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
            //you need to add this flag since you're starting a new activity from a service
            intent.putExtra("Come_From","Current_Location");
            Log.d("T", "about to start watch MainActivity from CurrentLocation");
            startActivity(intent);
        } else {
            super.onMessageReceived( messageEvent );
        }

    }
}