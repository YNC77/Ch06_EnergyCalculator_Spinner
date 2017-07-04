package com.example.ync.ch06_energycalculator_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
                implements AdapterView.OnItemSelectedListener{
    double[] rateData = {3.5, 5.5, 4};
    Spinner menu;
    TextView rate, result, remind;
    EditText weight, hours;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = (Spinner) findViewById(R.id.spinnerMenu);
        rate = (TextView) findViewById(R.id.sportRate);
        result = (TextView) findViewById(R.id.calResult);
        remind = (TextView) findViewById(R.id.sweetRemind);
        weight = (EditText) findViewById(R.id.userWeight);
        hours = (EditText) findViewById(R.id.userHours);
        menu.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        rate.setText(String.valueOf(rateData[position]));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calc(View v) {
        String w = weight.getText().toString();
        String h = hours.getText().toString();
        if(w.isEmpty() ||w.equals(".") ||h.isEmpty() ||h.equals(".")) {
            remind.setText("Please fill in the weight&hours");
            return;
        }

        int pos = menu.getSelectedItemPosition();
        long kCal = Math.round(rateData[pos]*Double.parseDouble(w)*Double.parseDouble(h));
        result.setText(String.format("Burn %d Calories",kCal));
        if(kCal>300) {
            remind.setText("Please have more water");
        } else {
            remind.setText("Please exercise more");
        }
    }
}
