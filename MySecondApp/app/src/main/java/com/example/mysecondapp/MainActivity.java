package com.example.mysecondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String INPUT_TEMP_KEY = "inputTemperature";
    private static final String CONVERTED_RESULT_KEY = "convertedResult";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputTempText = findViewById(R.id.inputTempEditText);
        Button convertButton = findViewById(R.id.convertButton);
        TextView convertedText = findViewById(R.id.convertedTempTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strFh = convertToFh(inputTempText.getText().toString());
                convertedText.setText(strFh + "F");
            }
        });

        // Restore state if it exists
        if (savedInstanceState != null) {
            String inputTemp = savedInstanceState.getString(INPUT_TEMP_KEY, "");
            String result = savedInstanceState.getString(CONVERTED_RESULT_KEY, "");

            inputTempText.setText(inputTemp);
            convertedText.setText(result);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        EditText inputTempText = findViewById(R.id.inputTempEditText);
        TextView convertedText = findViewById(R.id.convertedTempTextView);

        state.putString(INPUT_TEMP_KEY, inputTempText.getText().toString());
        state.putString(CONVERTED_RESULT_KEY, convertedText.getText().toString());

        super.onSaveInstanceState(state);
    }

    private String convertToFh(String pCelsius) {
        try {
            double c = Double.parseDouble(pCelsius);
            double f = c * (9.0 / 5.0) + 32.0;
            return String.format("%3.2f", f);
        } catch (NumberFormatException nfe) {
            return "ERR";
        }
    }
}
