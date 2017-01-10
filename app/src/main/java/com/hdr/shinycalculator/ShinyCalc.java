package com.hdr.shinycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ShinyCalc extends AppCompatActivity {

    TextView encValue;
    int counter = 0;

    TextView currChance;
    int encChance = 1/4096;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiny_calc);

        encValue = (TextView) findViewById(R.id.enCounter);
        currChance = (TextView) findViewById(R.id.encChance);

        Spinner dropdown = (Spinner) findViewById(R.id.modeSet);
        String[] items = new String[]{"Matsuda", "S.O.S"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void increaseCount(View view) {
        counter++;
        encValue.setText(Integer.toString(counter));
         if (counter <= 69) {
            encChance = 1/4096;
            currChance.setText(Integer.toString(encChance));
            if (counter >= 69) {
                encChance = 1/1024;
                currChance.setText(Integer.toString(encChance));
            }
         }
        }

    public void decreaseCount(View view) {
        if (counter == 0) {
            //Do Nothing
        }
        else if (counter >= 1) {
            counter--;
            encValue.setText(Integer.toString(counter));
        }
    }

    public void resetCount(View view) {
        counter = 0;
        encValue.setText(String.valueOf(counter));
    }

    public void currChanceCount (View view) { //Ignore This
     if (counter <= 69) {
        encChance = 1 / 4096;
        currChance.setText(Integer.toString(encChance));
        if (counter >= 69) {
            encChance = 1 / 1024;
            currChance.setText(Integer.toString(encChance));
        }
     }
    }


    }