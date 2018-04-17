package com.example.mac.studyapp02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        TextView text= (TextView)findViewById(R.id.view1);
        TextView textT= (TextView)findViewById(R.id.title);
        Intent intent=getIntent();
        String dir=intent.getStringExtra("dir");
        String title= intent.getStringExtra("title");
        textT.setText(title);


          try {
              FileReader rd= new FileReader(dir);
            BufferedReader bufferRd = new BufferedReader(rd);
                String content="", temp="";
                        while( (temp = bufferRd.readLine()) != null ) {
                                content += temp;
                            }

              text.setText(content);
                       Log.v(null,""+content);
                    } catch (Exception e) {}




    }


    }

