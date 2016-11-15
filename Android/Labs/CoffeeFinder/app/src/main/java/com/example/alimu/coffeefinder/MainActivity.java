package com.example.alimu.coffeefinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private searchCoffeeShop myCoffeeShop = new searchCoffeeShop();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button);
        //create listener
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                findCoffee(view);
            }
        };
        //add listener to the button
        button.setOnClickListener(onclick);
    }

    public void findCoffee(View view){
        //get spinner
        Spinner crowdSpinner = (Spinner)findViewById(R.id.spinner);
        //get spinner item array position
        Integer crowd = crowdSpinner.getSelectedItemPosition();
        //set the coffee shop
        myCoffeeShop.setCoffeeShop(crowd);
        //get suggested coffee shop
        String suggestedCoffeeShop = myCoffeeShop.getCoffeeShop();
        //get URL of suggested coffee shop
        String suggestedCoffeeShopURL = myCoffeeShop.getCoffeeShopURL();
        System.out.println(suggestedCoffeeShop);
        System.out.println(suggestedCoffeeShopURL);

        //create an intent
        Intent intent = new Intent(this, Main2Activity.class);

        //pass data
        intent.putExtra("coffeeShopName", suggestedCoffeeShop);
        intent.putExtra("coffeeShopURL", suggestedCoffeeShopURL);

        //start the intent
        startActivity(intent);
    }
}
