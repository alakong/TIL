package com.example.mac.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   Button button1=(Button)findViewById(R.id.button1 );
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

    }

    public void imgToast(View v){
        Toast ts= Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT);
        ImageView img= new ImageView(getApplicationContext());
        img.setImageResource(R.drawable.dang);
        ts.setView(img);
        ts.setGravity(Gravity.CENTER,100,100);
        ts.show();

    }

    public void mvCal(View v) {

        Intent intent = new Intent(MainActivity.this, CalActivity.class);
        startActivity(intent);
    }

    public void quit(View v){
        finish();

    }

}

