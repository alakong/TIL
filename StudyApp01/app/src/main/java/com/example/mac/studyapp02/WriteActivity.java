package com.example.mac.studyapp02;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteActivity extends AppCompatActivity {

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);




    }


    public void savePop(View v){

        final EditText edittext = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("저장할건가요?");
        builder.setMessage("저장할거면 이름 입력");
        builder.setView(edittext);
        builder.setPositiveButton("저장",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        save(edittext.getText().toString());
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();

    }

    public void save(String name){

        EditText text=(EditText)findViewById(R.id.editText1);
        String str= text.getText().toString();
        String sdPath= Environment.getExternalStorageDirectory().getAbsolutePath();
        sdPath+="/MyDir";
        File fileDir=new File(sdPath+"/"+name);
        FileOutputStream st;

        try {
            st = new FileOutputStream(fileDir);
            st.write(str.getBytes());
            st.close();
            Toast.makeText(getApplicationContext(),name+".txt 저장성공!" ,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(WriteActivity.this,MainActivity.class);
            startActivity(intent);

        }catch(IOException e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"저장실패!" ,Toast.LENGTH_LONG).show();

        }


    }


}
