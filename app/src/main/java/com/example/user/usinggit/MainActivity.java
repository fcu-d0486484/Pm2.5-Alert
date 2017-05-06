package com.example.user.usinggit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//右上角那三個點點的設定 利用 'menu物件'
        //menu.add(groupId, itemId, order, title) 用這方式加入 item
        /*第一個是groupId, 代表你是屬於那一個Group，通常都會設定為Menu.NONE
          第二個參數代表你是Menu Item Id,
          第三個參數是你放入Item的順序,假如你都設為Menu.NONE代表使用預設
          第四個參數就是你想要放入的標題*/
        for(int i = 0; i < 5; i++){
            menu.add(Menu.NONE, Menu.FIRST + i, Menu.NONE, "Item " + Integer.toString(i + 1));
        }
        return super.onCreateOptionsMenu(menu);
    }
}
