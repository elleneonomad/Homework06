package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void fruitBtnClickHandler(View view){
        showFoodView("Strawberry", R.drawable.strawberry);
    }
    public void vegetableBtnClickHandler(View view){
        showFoodView("Broccoli", R.drawable.broccoli);
    }
    public void drinkBtnClickHandler(View view){
        showFoodView("Coke", R.drawable.coke);
    }

    private void showFoodView(String foodName, int drawableImage){
//        store data in bundle
        Bundle dataBundle = new Bundle();
        dataBundle.putString("name", foodName);
        dataBundle.putInt("image", drawableImage);
//        start new activity
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), com.example.myapplication.FoodDetails.class);
        intent.putExtras(dataBundle);
        startActivity(intent);
    }
    public void callBtnListener(View view) {
        Uri number = Uri.parse("tel:070353052");
        Intent callIntent = new Intent(Intent.ACTION_DIAL,number);
        startActivity(callIntent);
    }

    public void webBtnListener(View view) {
        Uri webpage = Uri.parse("https://www.limkokwing.net");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }
}