package com.example.allie.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by allie on 3/2/16.
 */
public class RepresentativeFragment extends Fragment{
    String repName;
    String party;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        Bundle passedData = getArguments();
        repName = passedData.getString("RepName");
        party = passedData.getString("RepParty");
        View view = inflater.inflate(R.layout.representative_fragment, parent, false);
        Button repNameButton = (Button) view.findViewById(R.id.rep_name);
        repNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.d("T", "Button clicked");
                    Intent sendIntent = new Intent(getActivity(), WatchToPhoneService.class);
                    getActivity().startService(sendIntent);
                }
            });
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        Button repNameButton = (Button) view.findViewById(R.id.rep_name);
        TextView repParty = (TextView) view.findViewById(R.id.rep_party);
        repNameButton.setText(repName);
        repParty.setText(party);
        if(party != null) {
            switch (party) {
                case "Democratic Party":
                    repNameButton.setBackgroundColor(Color.parseColor("#0071BC"));
                    break;
                case "Republican Party":
                    repNameButton.setBackgroundColor(Color.parseColor("#FF0000"));
                    break;
                default:
                    repNameButton.setBackgroundColor(Color.parseColor("#9B51E0"));
            }

        }
    }

}
