package com.example.allie.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CongresionalViewActivity extends Activity {

    private TextView textinfo;
    private Intent currentIntent;
    private String intentType;
    private String intentData;
    private JSONArray representativesJSONArray;
    private ArrayList<JSONObject> representativesArray;
    private ListView representativesListView;
    public Map<String, Integer> imageMap = new HashMap<String, Integer>();
    public JSONObject senator1,senator2,representative1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.congressional_view);
        createJsonData();
        createSharedResources();
        currentIntent = getIntent();
        intentType = currentIntent.getStringExtra("TYPE_OF_DATA");
        intentData = currentIntent.getStringExtra("DATA");
        textinfo = (TextView) findViewById(R.id.textinfo);
        textinfo.setText(intentData);
        representativesListView = (ListView) findViewById(R.id.representatives_list);

        RepAdapter mRepresentativeAdapter = new RepAdapter(this, representativesArray);
        representativesListView.setAdapter(mRepresentativeAdapter);
    }

    private void createJsonData(){
        senator1 = new JSONObject();
        senator2 = new JSONObject();
        representative1 = new JSONObject();

        try {
            senator1.put("Name", "Dianne Feinstein");
            senator1.put("ImagePath", "feinstein_dianne");
            senator1.put("Party", "Democratic Party");
            senator1.put("email","");
            senator1.put("website","");
            senator1.put("twitterAccount","Dianne Feinstein latest tweet");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            senator2.put("Name", "Barbara Boxer");
            senator2.put("ImagePath", "boxer_barbara");
            senator2.put("Party", "Independent");
            senator2.put("email","");
            senator2.put("website","");
            senator2.put("twitterAccount","Latest Tweet of Barbara boxer about new policy");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            representative1.put("Name", "Barbara Lee");
            representative1.put("ImagePath", "lee_barbara");
            representative1.put("Party", "Democratic Party");
            representative1.put("email","");
            representative1.put("website","");
            representative1.put("twitterAccount","Latest Tweet of Barbara Lee regarding Oakland");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        representativesArray = new ArrayList<JSONObject>();
        representativesArray.add(senator1);
        representativesArray.add(senator2);
        representativesArray.add(representative1);

    }

    public void moreInfo(View v){
        Intent moreInfoViewIntent = new Intent(getBaseContext(),MoreInfoViewActivity.class);
        moreInfoViewIntent.putExtra("REP_Name","Barbara Lee");
        moreInfoViewIntent.putExtra("REP_Party", "Democratic Party");
        moreInfoViewIntent.putExtra("REP_End_term","Jan 3, 2017");
        moreInfoViewIntent.putExtra("REP_iamge_path","lee_barbara");
        startActivity(moreInfoViewIntent);
    }

    public void createSharedResources(){

        imageMap.put("lee_barbara", R.drawable.lee_barbara);
    }


}
