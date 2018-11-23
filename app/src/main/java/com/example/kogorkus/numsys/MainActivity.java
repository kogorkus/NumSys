package com.example.kogorkus.numsys;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    Button[] buttonsIn = new Button[4];
    Button[] buttonsOut = new Button[4];
    int SystemIn = 0, SystemOut = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonsIn[0] = findViewById(R.id.ButInDex);
        buttonsIn[1] = findViewById(R.id.ButInHex);
        buttonsIn[2] = findViewById(R.id.ButInOct);
        buttonsIn[3] = findViewById(R.id.ButInBin);
        buttonsOut[0] = findViewById(R.id.ButOutDex);
        buttonsOut[1] = findViewById(R.id.ButOutHex);
        buttonsOut[2] = findViewById(R.id.ButOutOct);
        buttonsOut[3] = findViewById(R.id.ButOutBin);

        edit = (EditText)findViewById(R.id.ETinput);
        edit.getBackground().setColorFilter(0xFFA3C2F3, PorterDuff.Mode.SRC_IN);
        edit.addTextChangedListener(inputTW);





    }

    //region ButtonMethods

    public void InToDex(View view) {

        ChangeColorIn(0);
    }

    public void InToHex(View view) {
        ChangeColorIn(1);
    }

    public void InToOct(View view) {
        ChangeColorIn(2);
    }

    public void InToBin(View view) {
        ChangeColorIn(3);
    }

    public void OutToDex(View view) {
        ChangeColorOut(0);
    }

    public void OutToHex(View view) {
        ChangeColorOut(1);
    }

    public void OutToBin(View view) {
        ChangeColorOut(3);
    }

    public void OutToOct(View view) {
        ChangeColorOut(2);
    }

    //endregion

    public void ChangeColorIn(int number)
    {
        for (int i = 0; i < 4; i++)
        {
             buttonsIn[i].setBackgroundColor(0xFFA3C2F3);
        }
        buttonsIn[number].setBackgroundColor(0xFF6CA7F4);
        SystemIn = number;
        EditText edit = (EditText)findViewById(R.id.ETinput);
        edit.setText(edit.getText().toString());
    }

    public void ChangeColorOut(int number)
    {
        for (int i = 0; i < 4; i++)
        {
            buttonsOut[i].setBackgroundColor(0xFFA3C2F3);
        }
        buttonsOut[number].setBackgroundColor(0xFF6CA7F4);
        SystemOut = number;
        EditText edit = (EditText)findViewById(R.id.ETinput);
        edit.setText(edit.getText().toString());
    }




    TextWatcher inputTW = new TextWatcher() {
        public void afterTextChanged(Editable s) {
            edit = (EditText)findViewById(R.id.ETinput);
            String InputStr = edit.getText().toString();
            String OutputStr = "";
            String CharStr = "";
            InputStr = InputStr.toUpperCase();
            int Calculatable = 0;

            int BaseOfInSys = 0;
            if(SystemIn == 0)
            {
                BaseOfInSys = 10;
                CharStr = "0123456789";
            }
            if(SystemIn == 1)
            {
                BaseOfInSys = 16;

                CharStr = "0123456789ABCDEF";
            }
            if(SystemIn == 2)
            {
                BaseOfInSys = 8;
                CharStr = "01234567";
            }
            if(SystemIn == 3)
            {
                BaseOfInSys = 2;
                CharStr = "01";
            }



            int[] CalculatableArr = new int[InputStr.length()];
            for(int i = 0; i < InputStr.length(); i++)
            {
                if (!CharStr.contains(Character.toString(InputStr.charAt(i))))
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
                Calculatable += CalculatableArr[i] * Math.pow(BaseOfInSys, CalculatableArr.length - i -1);
            }

            if(OutputStr != "Введены некорректные символы") {
                if (SystemOut == 0) OutputStr = Integer.toString(Calculatable);
                if (SystemOut == 1) OutputStr = Integer.toHexString(Calculatable);
                if (SystemOut == 2) OutputStr = Integer.toOctalString(Calculatable);
                if (SystemOut == 3) OutputStr = Integer.toBinaryString(Calculatable);
                OutputStr = OutputStr.toUpperCase();
            }
            TextView tview = (TextView)findViewById(R.id.TwResult);
            tview.setText(OutputStr);
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after){

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

    };


    public void StartSecondAct(View view) {
        Intent SecAct = new Intent(getApplicationContext(), ThirdActivity.class);
        startActivity(SecAct);
    }

    public void StartThirdAct(View view) {
        Intent SecAct = new Intent(getApplicationContext(), ThirdActivity.class);
        startActivity(SecAct);
    }
}
