package com.example.allie.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by allie on 2/29/16.
 */
public class MoreInfoViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_info_view);
        Intent currentIntent = getIntent();
        ImageView repImage = (ImageView) findViewById(R.id.rep_Big_image);
        TextView repName = (TextView) findViewById(R.id.rep_name);
        TextView repParty = (TextView) findViewById(R.id.rep_party);
        TextView repEndDate = (TextView) findViewById(R.id.rep_end_date);
        String image_loc = currentIntent.getStringExtra("REP_iamge_path");
        switch (image_loc) {
            case "lee_barbara":
                repImage.setImageResource(R.drawable.lee_barbara);
                break;
            case "boxer_barbara":
                repImage.setImageResource(R.drawable.boxer_barbara);
                break;
            case "feinstein_dianne":
                repImage.setImageResource(R.drawable.feinstein_dianne);
                break;
            default:
                repImage.setImageResource(R.drawable.lee_barbara);
        }
        repName.setText(currentIntent.getStringExtra("REP_Name"));
        repParty.setText(currentIntent.getStringExtra("REP_Party"));
        repEndDate.setText(currentIntent.getStringExtra("REP_End_term"));

    }
}
