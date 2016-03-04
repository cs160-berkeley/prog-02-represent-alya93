package com.example.allie.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import java.nio.charset.StandardCharsets;

/**
 * Created by allie on 3/3/16.
 */
public class PhoneListenerService extends WearableListenerService{
//   WearableListenerServices don't need an iBinder or an onStartCommand: they just need an onMessageReceieved.

    private static final String NAME = "/repMoreInfo";

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Log.d("T", "in PhoneListenerService, got: " + messageEvent.getPath());
        if( messageEvent.getPath().equalsIgnoreCase(NAME) ) {

            // Value contains the String we sent over in WatchToPhoneService, "good job"
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);

            // Make a toast with the String
            Context context = getApplicationContext();

            Intent moreInfoIntent = new Intent(context,MoreInfoViewActivity.class);
            moreInfoIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            moreInfoIntent.putExtra("REP_Name","Barbara Lee");
            moreInfoIntent.putExtra("REP_Party", "Democratic Party");
            moreInfoIntent.putExtra("REP_End_term","Jan 3, 2017");
            moreInfoIntent.putExtra("REP_iamge_path","lee_barbara");
            startActivity(moreInfoIntent);

        } else {
            super.onMessageReceived( messageEvent );
        }

    }

}
