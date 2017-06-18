package com.example.user.usinggit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        /**/
        final SeekBar seekBar=(SeekBar)findViewById(R.id.sb_volume);
        final TextView textView=(TextView)findViewById(R.id.alertPoint);
        textView.setText("10%");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.getProgress();
                textView.setText(seekBar.getProgress() + "%");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        Button completeBtn = (Button) findViewById(R.id.cmpBtn);
        completeBtn.setOnClickListener(clickCmpBtn);
    }
    private View.OnClickListener clickCmpBtn=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(Setting.this, "完成", Toast.LENGTH_SHORT).show();
            finish();
        }
    };
}
