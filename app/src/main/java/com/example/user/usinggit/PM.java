package com.example.user.usinggit;

/**
 * Created by willc on 2017/5/9.
 */

public class PM {
    public String date;
    public String loc;
    public String value;
    public String site;

    public PM(String date, String loc, String value, String site) {
        this.date = date;
        this.loc = loc;
        this.value = value;
        this.site = site;
    }

    public PM() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
