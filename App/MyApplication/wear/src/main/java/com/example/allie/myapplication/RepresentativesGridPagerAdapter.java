package com.example.allie.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by allie on 3/2/16.
 */
public class RepresentativesGridPagerAdapter extends FragmentGridPagerAdapter {
    private final Context mContext;
    private List mRows;
    public ArrayList<Page> PageRow = new ArrayList<Page>();
    public ArrayList<ArrayList<Page>> RepPages;

    public RepresentativesGridPagerAdapter(Context ctx, FragmentManager fm, Bundle data) {
        super(fm);
        mContext = ctx;
        createPages(data);
    }

// A simple container for static data in each page
    private class Page {
    // static resources
        String repName;
        String repParty;

        Page(String repName, String repParty){
            this.repName = repName;
            this.repParty = repParty;
        }

        Page(){
            this.repName = "Please, select location on your phone!";
            this.repParty = null;
        }

    }



    private void createPages(Bundle data){
        if(data!=null) {
            Page senator1 = new Page("Dianne Feinstein","Democratic Party");
            Page senator2 = new Page("Barbara Boxer","Independent");
            Page representative1  = new Page("Barbara Lee","Democratic Party");
            PageRow.add(senator1);
            PageRow.add(senator2);
            PageRow.add(representative1);
        } else {
            Page emptyPage = new Page();
            PageRow.add(emptyPage);
        }
        if(RepPages == null){
            RepPages = new ArrayList<ArrayList<Page>>();
        }
        RepPages.add(PageRow);
    }


    // Obtain the UI fragment at the specified position
    @Override
    public Fragment getFragment(int row, int col) {
        ArrayList<Page> Pages = RepPages.get(0);
        Page page = Pages.get(col);
                String title =
                page.repName != null ? page.repName : null;
        String text =
                page.repParty != null ? page.repParty : null;
        Bundle fragmentData = new Bundle();
        fragmentData.putString("RepName",title);
        fragmentData.putString("RepParty",text);
        RepresentativeFragment fragment = new RepresentativeFragment();
        fragment.setArguments(fragmentData);

        // Advanced settings (card gravity, card expansion/scrolling)
//        fragment.setCardGravity(page.cardGravity);
//        fragment.setExpansionEnabled(page.expansionEnabled);
//        fragment.setExpansionDirection(page.expansionDirection);
//        fragment.setExpansionFactor(page.expansionFactor);
        return fragment;
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    // Obtain the number of pages (horizontal)
    @Override
    public int getColumnCount(int rowNum) {
        ArrayList<Page> Pages = RepPages.get(0);
        return Pages.size();
    }
}
