package com.example.homework04;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.widget.RadioGroup;

public class PersonDetails extends AppCompatActivity {

    private EditText firstnameText, lastnameText, emailText, phoneText, dobText;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);

        // Initialize EditText fields
        firstnameText = findViewById(R.id.editTextFirstname);
        lastnameText = findViewById(R.id.editTextLastname);
        emailText = findViewById(R.id.editTextAddress);
        phoneText = findViewById(R.id.editTextPhone);
        dobText = findViewById(R.id.editTextDOB);
        radioGroup = findViewById(R.id.radioGroup);
    }

    @Override
    public void onBackPressed() {
        // Get values from EditText fields
        String fname = firstnameText.getText().toString();
        String lname = lastnameText.getText().toString();
        String gender = getSelectedGender(); // Function to get selected gender from RadioGroup
        String email = emailText.getText().toString();
        String phone = phoneText.getText().toString();
        String dob = dobText.getText().toString();

        // Create a new Person object
        Person person = new Person(fname, lname, gender, email, phone, dob);

        // Create Intent and pass Person object as ParcelableArrayListExtra
        Intent resultIntent = new Intent();
        ArrayList<Person> personData = new ArrayList<>();
        personData.add(person);
        resultIntent.putParcelableArrayListExtra("PersonData", personData);
        setResult(RESULT_OK, resultIntent);

        super.onBackPressed();
    }

    // Function to get selected gender from RadioGroup
    private String getSelectedGender() {
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId == R.id.radioButtonMale) {
            return "Male";
        } else if (selectedRadioButtonId == R.id.radioButtonFemale) {
            return "Female";
        } else {
            return ""; // No gender selected
        }
    }
}
