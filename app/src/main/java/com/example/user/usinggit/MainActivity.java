package com.example.user.usinggit;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.user.usinggit.R.string.about;
import static com.example.user.usinggit.R.string.exit;
import static com.example.user.usinggit.R.string.setting;


public class MainActivity extends AppCompatActivity {
    static int SETTING = 123;//Menu Item Id
    static int ABOUT = 456;//Menu Item Id
    static int EXIT = 789;//Menu Item Id
    static int MAIN_GROUP_ITEM = 101;//Menu Item GROUP ID
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mclass = (ListView)findViewById(R.id.mylist);
        ArrayList<placepm> testlist=new ArrayList<>();
        testlist.add(new placepm("Taichung",12.5));
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
