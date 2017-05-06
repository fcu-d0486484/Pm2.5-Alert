package com.example.user.usinggit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

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

    }
}
