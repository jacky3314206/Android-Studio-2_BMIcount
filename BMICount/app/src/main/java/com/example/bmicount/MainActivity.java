package com.example.bmicount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(calcBMI);
    }

    private View.OnClickListener calcBMI = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DecimalFormat nf = new DecimalFormat("0.00");
            EditText fieldheight = (EditText) findViewById(R.id.height);
            EditText fieldweight = (EditText) findViewById(R.id.weight);

            double height = Double.parseDouble(fieldheight.getText().toString()) / 100;

            double weight = Double.parseDouble(fieldweight.getText().toString());

            double BMI = weight / (height * height);

            
            TextView result = (TextView) findViewById(R.id.result);
            result.setText(getText(R.string.bmi_result)
                    + nf.format(BMI));
        }
    };
}