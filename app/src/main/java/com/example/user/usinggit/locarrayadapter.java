package com.example.user.usinggit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by willc on 2017/5/9.
 */

public class locarrayadapter extends ArrayAdapter<PM>{
    Context context;
    public locarrayadapter(Context context, ArrayList<PM> items){
        super(context,0,items);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        LinearLayout itemlayout = null;
        if(convertView == null) {
            itemlayout = (LinearLayout)inflater.inflate
                    (R.layout.listitem, null);
        } else {
            itemlayout = (LinearLayout) convertView;
        }
        PM item = (PM)getItem(position);

        TextView loc = (TextView)itemlayout.
                findViewById(R.id.loctext);
        loc.setText(item.getLoc());
        TextView pmvalue = (TextView) itemlayout.
                findViewById(R.id.PMvalue);

       if(item.getValue() == null){
           String pmtext = new String(" PM2.5 is  " + item.getValue());
           pmvalue.setText(pmtext);
       }else if( Integer.parseInt(item.getValue()) < 10 ) {
            String pmtext = new String(" PM2.5 is " + "     " + item.getValue());
            pmvalue.setText(pmtext);
       }else{
            String pmtext = new String(" PM2.5 is    " + item.getValue());
            pmvalue.setText(pmtext);
       }

        String sitetext=new String("                         監測站:"+item.getSite());
        TextView site = (TextView) itemlayout.findViewById(R.id.SiteText);
        site.setText(sitetext);
        return itemlayout;
    }
}
