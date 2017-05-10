package com.example.user.usinggit;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by willc on 2017/5/10.
 */

public class GetPmXml {
    InputStream inputStream;
    public InputStream getInputStream(String urltext) {
        URL url=null;
        try {
            url=new URL(urltext);
        }catch (Exception e){
            e.printStackTrace();
        }
        URLConnection connection=null;
        try{
            connection=url.openConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            inputStream=connection.getInputStream();
        }catch (Exception e){
            e.printStackTrace();
        }
        return inputStream;
    }
}
