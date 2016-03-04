package com.example.allie.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextView;
    private Button presedentialVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        presedentialVote = (Button) findViewById(R.id.vote_2012);
        presedentialVote.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent presidentialIntent = new Intent(getBaseContext(),PresidentialVoteActivity.class);
                        presidentialIntent.putExtra("State","CA");
                        presidentialIntent.putExtra("County","Alameda");
                        presidentialIntent.putExtra("Obama_vote","51");
                        presidentialIntent.putExtra("Romney_vote","45");
                        startActivity(presidentialIntent);
                    }
                }

        );
        final GridViewPager pager = (GridViewPager) findViewById(R.id.pager);
        pager.setAdapter(new RepresentativesGridPagerAdapter(this, getFragmentManager(), extras));

    }


}
