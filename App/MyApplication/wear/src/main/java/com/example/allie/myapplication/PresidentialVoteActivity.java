package com.example.allie.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

public class PresidentialVoteActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presidential_vote);
        Intent presidentialInfo = getIntent();
        TextView state = (TextView) findViewById(R.id.state);
        TextView county = (TextView) findViewById(R.id.county);
        TextView obamaVote = (TextView) findViewById(R.id.obama_vote);
        TextView romneyVote = (TextView) findViewById(R.id.romney_vote);

        state.setText(presidentialInfo.getStringExtra("State"));
        county.setText(presidentialInfo.getStringExtra("County"));
        obamaVote.setText("Obama "+presidentialInfo.getStringExtra("Obama_vote")+"% of vote");
        romneyVote.setText("Romney "+presidentialInfo.getStringExtra("Romney_vote")+"% of vote");
    }
}
