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
    char encChance = 1/4096;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiny_calc);

        encValue = (TextView) findViewById(R.id.enCounter);
        currChance = (TextView) findViewById(R.id.encChance);

        Spinner dropdown = (Spinner) findViewById(R.id.modeSet);
        String[] items = new String[]{"Matsuda", "S.O.S", "Soft Reset"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void increaseCount(View view) {
          counter++;
          encValue.setText(Integer.toString(counter));
         if (counter <= 69) {
             currChance.setText("1/4096");
         }
        if (counter >= 70 && counter <= 255) {
            currChance.setText("1/1024");
        }
        if (counter >= 256 && counter <= 325) {
            currChance.setText("1/4096");

        }
        if (counter >= 325 && counter <= 510) {
            currChance.setText("1/1024");

        }
        if (counter >= 510 && counter <= 580) {
            currChance.setText("1/4096");
        }
        if (counter >= 580 && counter <= 765) {
            currChance.setText("1/1024");
        }
        if (counter >= 765 && counter <= 835) {
            currChance.setText("1/4096");
        }
        if (counter >= 835 && counter <= 1020) {
            currChance.setText("1/1024");
        }
     }

    public void decreaseCount(View view) {
        if (counter == 0) {
            //Do Nothing
        }
        else if (counter >= 1) {
            counter--;
            encValue.setText(Integer.toString(counter));
            if (counter <= 69) {
                currChance.setText("1/4096");
            }
            if (counter >= 70 && counter <= 255) {
                currChance.setText("1/1024");
            }
            if (counter >= 256 && counter <= 325) {
                currChance.setText("1/4096");

            }
            if (counter >= 325 && counter <= 510) {
                currChance.setText("1/1024");

            }
            if (counter >= 510 && counter <= 580) {
                currChance.setText("1/4096");
            }
            if (counter >= 580 && counter <= 765) {
                currChance.setText("1/1024");
            }
            if (counter >= 765 && counter <= 835) {
                currChance.setText("1/4096");
            }
            if (counter >= 835 && counter <= 1020) {
                currChance.setText("1/1024");
            }
        }
    }

    public void resetCount(View view) {
        counter = 0;
        encValue.setText(String.valueOf(counter));
        currChance.setText("1/4096");
    }



    }