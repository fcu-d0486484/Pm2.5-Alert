package com.example.user.usinggit;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import static com.example.user.usinggit.R.*;
import static com.example.user.usinggit.R.color.fpmi1;
import static com.example.user.usinggit.R.color.fpmi10;
import static com.example.user.usinggit.R.color.fpmi2;
import static com.example.user.usinggit.R.color.fpmi3;
import static com.example.user.usinggit.R.color.fpmi4;
import static com.example.user.usinggit.R.color.fpmi5;
import static com.example.user.usinggit.R.color.fpmi6;
import static com.example.user.usinggit.R.color.fpmi7;
import static com.example.user.usinggit.R.color.fpmi8;
import static com.example.user.usinggit.R.color.fpmi9;

/**
 * Created by willc on 2017/5/9.
 */

public class locarrayadapter extends ArrayAdapter<PM>{
    Context context;
    public locarrayadapter(Context context, ArrayList<PM> items){
        super(context,0,items);
        this.context=context;
    }

    @SuppressWarnings("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        AtomicReference<LinearLayout> itemlayout = new AtomicReference<LinearLayout>();
        if(convertView == null) {
            itemlayout.set((LinearLayout) inflater.inflate
                    (layout.listitem, null));
        } else {
            itemlayout.set((LinearLayout) convertView);
        }
        PM item = getItem(position);

        TextView loc = (TextView) itemlayout.get().
                findViewById(id.loctext);
        loc.setText(item.getLoc());
        TextView pmvalue = (TextView) itemlayout.get().
                findViewById(id.PMvalue);

       if(item.getValue() == null){
           String pmtext = new String(" PM2.5 is  " + item.getValue());
           pmvalue.setText(pmtext);
       }else if( Integer.parseInt(item.getValue()) < 10 ) {
            String pmtext = new String(" PM2.5 is " + "     " + item.getValue());
           colorChoice(item, pmvalue);
           pmvalue.setText(pmtext);
       }else if( Integer.parseInt(item.getValue()) < 100 ){
            String pmtext = new String(" PM2.5 is    " + item.getValue());
            pmvalue.setText(pmtext);
            colorChoice(item, pmvalue);
       }else{
           String pmtext = new String(" PM2.5 is  " + item.getValue());
           pmvalue.setText(pmtext);
           colorChoice(item, pmvalue);
       }

        String sitetext=new String("                         監測站:"+item.getSite());
        TextView site = (TextView) itemlayout.get().findViewById(id.SiteText);
        site.setText(sitetext);
        return itemlayout.get();
    }

    @SuppressWarnings("ResourceAsColor")
    public void colorChoice(PM item, TextView pmvalue){
        if(Integer.parseInt(item.getValue()) >=0 && Integer.parseInt(item.getValue()) <=11){
            pmvalue.setTextColor(Color.rgb(158,255,158));
        }else if(Integer.parseInt(item.getValue()) >=12 && Integer.parseInt(item.getValue()) <=23){
            pmvalue.setTextColor(Color.rgb(51,255,0));
        }else if(Integer.parseInt(item.getValue()) >=24 && Integer.parseInt(item.getValue()) <=35){
            pmvalue.setTextColor(Color.rgb(49,209,0));
        }else if(Integer.parseInt(item.getValue()) >=36 && Integer.parseInt(item.getValue()) <=41){
            pmvalue.setTextColor(Color.rgb(255,255,0));
        }else if(Integer.parseInt(item.getValue()) >=42 && Integer.parseInt(item.getValue()) <=47){
            pmvalue.setTextColor(Color.rgb(255,208,0));
        }else if(Integer.parseInt(item.getValue()) >=48 && Integer.parseInt(item.getValue()) <=53){
            pmvalue.setTextColor(Color.rgb(255,153,0));
        }else if(Integer.parseInt(item.getValue()) >=54 && Integer.parseInt(item.getValue()) <=58){
            pmvalue.setTextColor(Color.rgb(255,102,102));
        }else if(Integer.parseInt(item.getValue()) >=59 && Integer.parseInt(item.getValue()) <=64){
            pmvalue.setTextColor(Color.rgb(255,0,0));
        }else if(Integer.parseInt(item.getValue()) >=65 && Integer.parseInt(item.getValue()) <=70){
            pmvalue.setTextColor(Color.rgb(153,0,0));
        }else{
            pmvalue.setTextColor(Color.rgb(206,46,255));
        }

    }

}
