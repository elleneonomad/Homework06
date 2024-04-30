package com.example.homework04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PERSON_DETAILS = 1;
    private TextView textViewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDetails = findViewById(R.id.textViewDetails);

        Button buttonGetDetails = findViewById(R.id.buttonGetDetails);
        buttonGetDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PersonDetails.class);
                startActivityForResult(intent, REQUEST_CODE_PERSON_DETAILS);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PERSON_DETAILS && resultCode == RESULT_OK && data != null) {
            ArrayList<Person> personData = data.getParcelableArrayListExtra("PersonData");
            if (personData != null && !personData.isEmpty()) {
                Person person = personData.get(0);
                String details = "Name: " + person.getFirstname() + " " + person.getLastname() + "\n" +
                        "Gender: " + person.getGender() + "\n" +
                        "Email: " + person.getEmail() + "\n" +
                        "Phone: " + person.getPhone() + "\n" +
                        "DOB: " + person.getDob();
                textViewDetails.setText(details);
            }
        }
    }
}


