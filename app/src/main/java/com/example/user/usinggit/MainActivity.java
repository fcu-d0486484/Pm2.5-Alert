package com.example.user.usinggit;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static com.example.user.usinggit.R.string.about;
import static com.example.user.usinggit.R.string.exit;
import static com.example.user.usinggit.R.string.setting;


public class MainActivity extends AppCompatActivity {

    static int SETTING = 123;//Menu Item Id
    static int ABOUT = 456;//Menu Item Id
    static int EXIT = 789;//Menu Item Id
    static int MAIN_GROUP_ITEM = 101;//Menu Item GROUP ID

    InputStream pmfile=null;
    final String url=new String("http://opendata.epa.gov.tw/ws/Data/ATM00625/?$skip=0&$top=1000&format=xml");
    Button trycon;
    Button mklist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.waitingconnect);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        trycon=(Button)findViewById(R.id.Trybtn);
        trycon.setOnClickListener(clickget);
        mklist=(Button)findViewById(R.id.mkbtn);
        mklist.setOnClickListener(listgen);
    }
    private View.OnClickListener listgen=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(pmfile!=null){
                makelist();
            }
            else{
                Toast.makeText(MainActivity.this,"There is no data to show",Toast.LENGTH_SHORT).show();
            }
        }
    };
    private View.OnClickListener clickget=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast t=Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT);

            Thread getthread=new Thread(getxml);
            getthread.run();
                if(pmfile==null)
                    Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
        }
    };

    private Runnable getxml=new Runnable(){
        @Override
        public void run() {
            GetPmXml getxml=new GetPmXml();
            pmfile=getxml.getInputStream(url);
        }
    };
    private void makelist(){
        this.setContentView(R.layout.activity_main);
        Pmhandler pmhandler=new Pmhandler();
        SAXParserFactory factory;
        factory=SAXParserFactory.newInstance();
        SAXParser parser;
        parser=null;
        try {
            parser=factory.newSAXParser();
            parser.parse(pmfile,pmhandler);
            pmfile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ListView mclass = (ListView)findViewById(R.id.mylist);
        ArrayList<PM> testlist=pmhandler.getPMs();
        locarrayadapter outlist=new locarrayadapter(this,testlist);
        mclass.setAdapter(outlist);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//右上角那三個點點的設定 利用 'menu物件'
        //menu.add(groupId, itemId, order, title) 用這方式加入 item
        /*第一個是groupId, 代表你是屬於那一個Group，通常都會設定為Menu.NONE
          第二個參數代表你是Menu Item Id,
          第三個參數是你放入Item的順序,假如你都設為Menu.NONE代表使用預設
          第四個參數就是你想要放入的標題*/
        menu.add(MAIN_GROUP_ITEM, SETTING, Menu.NONE, setting);
        menu.add(MAIN_GROUP_ITEM, ABOUT, Menu.NONE, about);
        menu.add(MAIN_GROUP_ITEM, EXIT, Menu.NONE, exit);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//處理按下Menu Item以後的動作
        if(item.getGroupId() == MAIN_GROUP_ITEM){
            if(item.getItemId() == EXIT){//按下 "離開" 按鈕 的動作
                dialog_exit();
            }
            if(item.getItemId() == SETTING){//按下 "設定" 按鈕 的動作
                goSetting();
            }
            if(item.getItemId() == ABOUT){//按下 "關於" 按鈕 的動作
                dialog_about();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void dialog_exit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("確定要離開嗎?");
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener()  {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); //dismiss為關閉dialog,Activity還會保留dialog的狀態
                MainActivity.this.finish();//關閉activity
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener()  {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void dialog_about(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("內容なし");
        builder.show();
    }

    private void goSetting(){
        Intent intent = new Intent(MainActivity.this, Setting.class);
        startActivity(intent);
    }
}
