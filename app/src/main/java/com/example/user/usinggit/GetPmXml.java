package com.example.user.usinggit;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by willc on 2017/5/10.
 */

public class GetPmXml {
    InputStream inputStream;

    public InputStream getInputStream(String urltext) {
        URL url = null;
        try {
            url = new URL(urltext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            inputStream = new BufferedInputStream(connection.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return inputStream;
    }
}
