package com.example.kogorkus.numsys;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView textViewInput;
    SeekBar seekBarInput;
    TextView textViewOutput;
    SeekBar seekBarOutput;
    EditText editTextPro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        seekBarInput = (SeekBar) findViewById(R.id.seekBarInput);
        textViewInput = (TextView) findViewById(R.id.txtViewInput);
        seekBarOutput = (SeekBar) findViewById(R.id.seekBarOutput);
        textViewOutput = (TextView) findViewById(R.id.txtViewOutput);
        editTextPro = (EditText)findViewById(R.id.editTextPro);
        editTextPro.getBackground().setColorFilter(0xFFA3C2F3, PorterDuff.Mode.SRC_IN);
        editTextPro.addTextChangedListener(inputTWPro);


        seekBarInput.setOnSeekBarChangeListener(SBListenerIn);
        seekBarOutput.setOnSeekBarChangeListener(SBListenerOut);
    }
    SeekBar.OnSeekBarChangeListener SBListenerIn = new SeekBar.OnSeekBarChangeListener()
    {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            textViewInput.setText(String.valueOf(progress + 2));
            Convert();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    SeekBar.OnSeekBarChangeListener SBListenerOut = new SeekBar.OnSeekBarChangeListener()
    {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            textViewOutput.setText(String.valueOf(progress + 2));
            Convert();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    TextWatcher inputTWPro = new TextWatcher() {
        public void afterTextChanged(Editable s) {
            Convert();
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after){

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

    };
    public void Convert()
    {
        editTextPro = (EditText)findViewById(R.id.editTextPro);
        String InputStr = editTextPro.getText().toString();
        String OutputStr = "";
        String CharStr = "0123456789ABCDEF";
        InputStr = InputStr.toUpperCase();
        int Calculatable = 0;

        int[] CalculatableArr = new int[InputStr.length()];
        for(int i = 0; i < InputStr.length(); i++)
        {
            if (!CharStr.substring(0, seekBarInput.getProgress() + 2).contains(Character.toString(InputStr.charAt(i))))
            {
                OutputStr = "Введены некорректные символы";
                break;
            }
            else if(InputStr.charAt(i) == 'A') CalculatableArr[i] = 10;
            else if(InputStr.charAt(i) == 'B') CalculatableArr[i] = 11;
            else if(InputStr.charAt(i) == 'C') CalculatableArr[i] = 12;
            else if(InputStr.charAt(i) == 'D') CalculatableArr[i] = 13;
            else if(InputStr.charAt(i) == 'E') CalculatableArr[i] = 14;
            else if(InputStr.charAt(i) == 'F') CalculatableArr[i] = 15;
            else
            {
                CalculatableArr[i] =  Character.getNumericValue(InputStr.charAt(i));
            }

        }
        for(int i = 0; i < CalculatableArr.length; i++)
        {
            Calculatable += CalculatableArr[i] * Math.pow(seekBarInput.getProgress() + 2, CalculatableArr.length - i -1);
        }

        if(OutputStr != "Введены некорректные символы") {
            while (Calculatable > 0)
            {
                int temp = (Calculatable % (seekBarOutput.getProgress() + 2));
                if(temp == 15) OutputStr = "F" + OutputStr;
                else if(temp == 14) OutputStr = "E" + OutputStr;
                else if(temp == 13) OutputStr = "D" + OutputStr;
                else if(temp == 12) OutputStr = "C" + OutputStr;
                else if(temp == 11) OutputStr = "B" + OutputStr;
                else if(temp == 10) OutputStr = "A" + OutputStr;
                else OutputStr = temp + OutputStr;
                Calculatable /= seekBarOutput.getProgress() + 2;
            }
            OutputStr = OutputStr.toUpperCase();
        }
        TextView tview = (TextView)findViewById(R.id.TVOutput);
        tview.setText(OutputStr);
    }
}
