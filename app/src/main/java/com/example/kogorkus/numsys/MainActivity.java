package com.example.kogorkus.numsys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button[] buttonsIn = new Button[4];
    Button[] buttonsOut = new Button[4];
    Boolean[] Input = new Boolean[4];
    Boolean[] Output = new Boolean[4];
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
    }

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
    public void ChangeColorIn(int number)
    {
        for (int i = 0; i < 4; i++)
        {
             buttonsIn[i].setBackgroundColor(0xFFD4D5D6);
             Input[i] = false;
        }
        buttonsIn[number].setBackgroundColor(0xFF00FF00);
        Input[number] = true;
    }
    public void ChangeColorOut(int number)
    {
        for (int i = 0; i < 4; i++)
        {
            buttonsOut[i].setBackgroundColor(0xFFD4D5D6);
            Output[i] = false;
        }
        buttonsOut[number].setBackgroundColor(0xFF00FF00);
        Output[number] = true;
    }

    public void result(View view) {
        EditText edit = (EditText)findViewById(R.id.ETinput);
        String InputStr = edit.getText().toString();
        InputStr = InputStr.toUpperCase();
        String OutputStr = "";
        String Calculatable = "";
        int sys1 = -1, sys2 = -1;
        for (int i = 0; i < 4; i ++)
        {
            if(Input[i]) sys1 = i;
            if(Output[i]) sys2 = i;
        }
        if(sys1 == 3) Calculatable = InputStr;
        if(sys1 == 0)
        {
            int temp = Integer.parseInt(InputStr);
            while (temp >= 1) {
                Calculatable = (temp % 2) + Calculatable;
                temp /= 2;
            }
        }
        if(sys1 == 1)
        {
            for(int i = 0; i < InputStr.length(); i++)
            {
                if(InputStr.charAt(i) == '1' ) Calculatable += "0001";
                if(InputStr.charAt(i) == '2' ) Calculatable += "0010";
                if(InputStr.charAt(i) == '3' ) Calculatable += "0011";
                if(InputStr.charAt(i) == '4' ) Calculatable += "0100";
                if(InputStr.charAt(i) == '5' ) Calculatable += "0101";
                if(InputStr.charAt(i) == '6' ) Calculatable += "0110";
                if(InputStr.charAt(i) == '7' ) Calculatable += "0111";
                if(InputStr.charAt(i) == '8' ) Calculatable += "1000";
                if(InputStr.charAt(i) == '9' ) Calculatable += "1001";
                if(InputStr.charAt(i) == 'A' ) Calculatable += "1010";
                if(InputStr.charAt(i) == 'B' ) Calculatable += "1011";
                if(InputStr.charAt(i) == 'C' ) Calculatable += "1100";
                if(InputStr.charAt(i) == 'D' ) Calculatable += "1101";
                if(InputStr.charAt(i) == 'E' ) Calculatable += "1110";
                if(InputStr.charAt(i) == 'F' ) Calculatable += "1111";
                if(InputStr.charAt(i) == '0' ) Calculatable += "0000";
            }
        }
        if(sys1 == 2)
        {
            for(int i = 0; i < InputStr.length(); i++)
            {
                if(InputStr.charAt(i) == '1' ) Calculatable += "001";
                if(InputStr.charAt(i) == '2' ) Calculatable += "010";
                if(InputStr.charAt(i) == '3' ) Calculatable += "011";
                if(InputStr.charAt(i) == '4' ) Calculatable += "100";
                if(InputStr.charAt(i) == '5' ) Calculatable += "101";
                if(InputStr.charAt(i) == '6' ) Calculatable += "110";
                if(InputStr.charAt(i) == '7' ) Calculatable += "111";
                if(InputStr.charAt(i) == '0' ) Calculatable += "000";
            }
        }
        if(sys2 == 0)
        {
            int temp = 0;
            for(int i = 0; i < Calculatable.length(); i++)
            {
                if(Calculatable.charAt(i) == '1') temp += Math.pow(2, Calculatable.length() - i - 1);
            }
            OutputStr = Integer.toString(temp);
        }
        if(sys2 == 3) OutputStr = Calculatable;
        TextView tview = (TextView)findViewById(R.id.TwResult);
        tview.setText(OutputStr);



    }
}
