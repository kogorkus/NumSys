package com.example.kogorkus.numsys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView textViewInput;
    SeekBar seekBarInput;
    TextView textViewOutput;
    SeekBar seekBarOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        seekBarInput = (SeekBar) findViewById(R.id.seekBarInput);
        textViewInput = (TextView) findViewById(R.id.txtViewInput);
        seekBarOutput = (SeekBar) findViewById(R.id.seekBarOutput);
        textViewOutput = (TextView) findViewById(R.id.txtViewOutput);
        seekBarInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textViewInput.setText(String.valueOf(progress + 2));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarOutput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textViewOutput.setText(String.valueOf(progress + 2));
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
