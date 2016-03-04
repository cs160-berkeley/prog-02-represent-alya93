package com.example.allie.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Button currentLocationButton;
    protected Button continueButton;
    protected EditText zipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zipCode = (EditText) findViewById(R.id.ZipCode_field);
        continueButton = (Button) findViewById(R.id.continue_button);
        zipCode.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void afterTextChanged(Editable s) {
                if (zipCode.getText().length() == 5) {
                    continueButton.setEnabled(true);
                } else {
                    continueButton.setEnabled(false);
                }

            }

        });

        continueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent congressionalViewIntent = new Intent(getBaseContext(),CongresionalViewActivity.class);
                String enteredZipCode = zipCode.getText().toString();
                congressionalViewIntent.putExtra("DATA", enteredZipCode);
                congressionalViewIntent.putExtra("TYPE_OF_DATA", "zipCode");
                startActivity(congressionalViewIntent);
                Intent congressionalViewWatchIntent = new Intent(getBaseContext(),PhoneToWatchService.class);
                congressionalViewWatchIntent.putExtra("DATA", enteredZipCode);
                congressionalViewWatchIntent.putExtra("TYPE_OF_DATA", "zipCode");
                startService(congressionalViewWatchIntent);
            }
        });

        currentLocationButton = (Button) findViewById(R.id.currentLocation_button);

        currentLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent congressionalViewIntent = new Intent(getBaseContext(), CongresionalViewActivity.class);
                String currentLocationCoordinates = "37.8717° N, 122.2728° W";
                congressionalViewIntent.putExtra("DATA", currentLocationCoordinates);
                congressionalViewIntent.putExtra("TYPE_OF_DATA", "currentLocation");
                startActivity(congressionalViewIntent);
                Intent congressionalViewWatchIntent = new Intent(getBaseContext(),PhoneToWatchService.class);
                congressionalViewWatchIntent.putExtra("DATA", currentLocationCoordinates);
                congressionalViewWatchIntent.putExtra("TYPE_OF_DATA", "currentLocation");
                startService(congressionalViewWatchIntent);
            }
        });
    }



}
