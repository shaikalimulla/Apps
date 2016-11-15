package com.example.alimu.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeImage(View view){
        Button button = (Button) findViewById(R.id.button);

        EditText username = (EditText) findViewById(R.id.userName);
        String nameVal = username.getText().toString();

        TextView text = (TextView) findViewById(R.id.msg);
        text.setText("Happy Holloween "+nameVal+"!");

        ImageView imageView = (ImageView) findViewById(R.id.img);
        //imageView.setImageResource(R.drawable.taj_mahal);
        imageView.setImageResource(R.drawable.ghost);
        //setContentView(imageView);


    }
}
