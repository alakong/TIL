package com.example.mac.myapplication;

import android.os.Bundle;
import android.os.PatternMatcher;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.regex.Pattern;

public class CalActivity extends AppCompatActivity {

    private TextView screen;//액티비티에서 화면 보이는 곳
    private String display=""; //내부적으로 입력한 글자 저장되는 공간
    private String oper="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        screen=(TextView)findViewById(R.id.result);
        screen.setText(display);

    }

    public void updateScreen(){
        screen.setText(display);
    }
    public void onClickNumber(View v){
        Button b=(Button) v;
        display += b.getText();
        updateScreen();
    }

    public void onClickOper(View v){
        Button b=(Button) v;
        display +=b.getText();
        oper=b.getText().toString();
        updateScreen();
    }

    public void clear(){
        display="";
        oper="";
    }

    public void onClickClear(View v){
        clear();
        updateScreen();
    }
    public void onClickEqual(View v){
        String[] arr=display.split(Pattern.quote(oper));
        long result=0;

        for(int i=0;i<arr.length;i++){
            result += Long.parseLong(arr[i]);
        }
        clear();
        System.out.print(result);
        display=String.valueOf(result);
        updateScreen();


    /*    String str1=display.split(oper)[0];
        String str2=display.split(oper)[1];

        int result=Integer.parseInt(str1)*10+Integer.parseInt(str2);*/
    }

}
