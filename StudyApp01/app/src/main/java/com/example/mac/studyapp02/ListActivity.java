package com.example.mac.studyapp02;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        ListView listview= (ListView) findViewById(R.id.list);
        String sdPath= Environment.getExternalStorageDirectory().getAbsolutePath();
        sdPath+="/MyDir";
        File fileDir=new File(sdPath);
        File[] files= fileDir.listFiles();
        List<String> fileNameList= new ArrayList<>();
        for(File f: files){
                fileNameList.add(f.getName());
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,fileNameList) ;
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                String filename = Environment.getExternalStorageDirectory().getAbsolutePath()+"/MyDir/"+(String) parent.getItemAtPosition(position);
                mvRead(v,filename,(String) parent.getItemAtPosition(position));
            }
        }) ;



    }

    public void mvRead(View v,String str,String str2){
        Intent intent = new Intent(ListActivity.this,ReadActivity.class);
        intent.putExtra("dir",str);
        intent.putExtra("title",str2);
        startActivity(intent);
    }








}
