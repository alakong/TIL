package com.example.mac.studyapp02;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       String sdPath= Environment.getExternalStorageDirectory().getAbsolutePath();
        sdPath+="/MyDir";
        File fileDir=new File(sdPath);
        if(!fileDir.exists()){
            fileDir.mkdir();
        }

    }


    public void mv(Class s){
        Intent intent = new Intent(MainActivity.this,s);
        startActivity(intent);
    }
    public void mvWrite(View v) {
        mv(WriteActivity.class);
    }

    public void mvList(View v){
        mv(ListActivity.class);
    }

    public void quit(View v){
        finish();
    }




}
