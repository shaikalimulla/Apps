package com.example.ali.loginregister;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout resultlayout;
    TextView BookTitle;
    TextView Price;
    Button buy;
private String title;
    private String pri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resultlayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.activity_result, null);
        setContentView(resultlayout);
        BookTitle = (TextView) resultlayout.findViewById(R.id.textBook);
        Price = (TextView) resultlayout.findViewById(R.id.textPrice);
        Bundle extras = getIntent().getExtras();
        title = extras.getString("Book");
    pri = extras.getString("Price");
        BookTitle.setText(title);
    Price.setText(pri);
    }

    @Override
    protected void onResume() {
        super.onResume();
        buy = (Button) resultlayout.findViewById(R.id.buttonBuy);
        buy.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(ResultActivity.this);
        alert.setTitle("CONFIRMATION!!");
        alert.setMessage("Are you sure you want to buy this book");

        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Please contact the seller aayushgrover.dx@gmail.com within next 2 days", Toast.LENGTH_LONG).show();
                 ReservationManager.Reserve(title);

            }
        });

        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Sorry to not meet up your needs", Toast.LENGTH_LONG).show();
            }
        });





    }
}
