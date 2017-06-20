package com.example.user.usinggit;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by willc on 2017/5/9.
 */

public class Pmhandler extends DefaultHandler{
    private ArrayList<PM> PMs;
    private PM pm;
    private String tagname=null;

    public ArrayList<PM> getPMs(){
        return PMs;
    }

    @Override
    public void startDocument() {
        PMs = new ArrayList<PM>();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        if (tagname != null) {
            String data = new String(ch, start, length);
            if (tagname.equals("Site"))
                pm.setSite(data);
            else if (tagname.equals("county"))
                pm.setLoc(data);
            else if (tagname.equals("PM25"))
                pm.setValue(data);
            else if (tagname.equals("DataCreationDate"))
                pm.setDate(data);
        }

    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) {
        if(localName.equals("Data")){
            pm=new PM();
        }
        tagname=localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if(localName.equals("Data")){
            PMs.add(pm);
            pm=null;
        }
        tagname=null;
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

}
