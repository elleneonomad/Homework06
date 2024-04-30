package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
//        get the data passed from the previous activity
        Bundle dataBundle = getIntent().getExtras();
        String foodName = dataBundle.getString("name");
        Drawable foodImg = getResources().getDrawable(dataBundle.getInt("image"));
////        connect to views
        TextView foodTextView = (TextView) findViewById(R.id.foodTextView);
        ImageView foodImageView = (ImageView) findViewById(R.id.foodImageView);

        foodTextView.setText(foodName);
        foodImageView.setImageDrawable(foodImg);
    }
}