package com.example.allie.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.res.Resources;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by allie on 2/29/16.
 */
public class RepAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<JSONObject> data;
    public JSONObject currentRep;

    public RepAdapter(Context context, ArrayList<JSONObject> repData) {
        this.context = context;
        this.data = repData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View repRow = inflater.inflate(R.layout.representative_list_view, parent, false);
        TextView repName = (TextView) repRow.findViewById(R.id.representative_name);
        TextView latestTweet = (TextView) repRow.findViewById(R.id.lasttweet);
        ImageView repImage = (ImageView) repRow.findViewById(R.id.representative_image);
        ImageView icons = (ImageView) repRow.findViewById(R.id.icons);
        icons.setImageResource(R.drawable.icons);

        currentRep = data.get(position);
        try {
            repName.setText(currentRep.getString("Name"));
            latestTweet.setText(currentRep.getString("twitterAccount"));
            String imagePath = currentRep.getString("ImagePath");
            String party = currentRep.getString("Party");
            switch (imagePath) {
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
            switch (party) {
                case "Democratic Party":
                    repImage.setBackgroundColor(Color.parseColor("#0071BC"));
                    break;
                case "Republican Party":
                    repImage.setBackgroundColor(Color.parseColor("#FF0000"));
                    break;
                default:
                    repImage.setBackgroundColor(Color.parseColor("#9B51E0"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    return repRow;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


}
