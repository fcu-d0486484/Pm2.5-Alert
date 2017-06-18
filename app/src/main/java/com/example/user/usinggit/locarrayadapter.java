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
        if(Integer.parseInt(item.getValue()) == 1){
            pmvalue.setTextColor(fpmi1);
        }else if(Integer.parseInt(item.getValue()) == 2){
            pmvalue.setTextColor(fpmi2);
        }else if(Integer.parseInt(item.getValue()) == 3){
            pmvalue.setTextColor(fpmi3);
        }else if(Integer.parseInt(item.getValue()) == 4){
            pmvalue.setTextColor(fpmi4);
        }else if(Integer.parseInt(item.getValue()) == 5){
            pmvalue.setTextColor(fpmi5);
        }else if(Integer.parseInt(item.getValue()) == 6){
            pmvalue.setTextColor(fpmi6);
        }else if(Integer.parseInt(item.getValue()) == 7){
            pmvalue.setTextColor(fpmi7);
        }else if(Integer.parseInt(item.getValue()) == 8){
            pmvalue.setTextColor(fpmi8);
        }else if(Integer.parseInt(item.getValue()) == 9){
            pmvalue.setTextColor(fpmi9);
        }else{
            pmvalue.setTextColor(fpmi10);
        }

    }

}
