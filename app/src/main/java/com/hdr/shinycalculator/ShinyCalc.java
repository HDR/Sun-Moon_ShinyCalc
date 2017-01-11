package com.hdr.shinycalculator;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ShinyCalc extends AppCompatActivity {

    TextView encValue;
    int counter = 0;

    TextView currChance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiny_calc);

        encValue = (TextView) findViewById(R.id.enCounter);
        currChance = (TextView) findViewById(R.id.encChance);

        SharedPreferences cS = PreferenceManager.getDefaultSharedPreferences(this);
        int counter = cS.getInt("counterNum", 0);
        encValue.setText(Integer.toString(counter));

        Spinner dropdown = (Spinner) findViewById(R.id.modeSet);
        String[] items = new String[]{"S.O.S", "Matsuda", "Soft Reset"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void increaseCount(View view) {
        counter++;
        encValue.setText(Integer.toString(counter));
        ChanceInfo();
        saveData();
    }

    public void decreaseCount(View view) {
        if (counter == 0) {
            //Do Nothing
        }
        else if (counter >= 1) {
            counter--;
            encValue.setText(Integer.toString(counter));
            ChanceInfo();
            saveData();
        }
    }

    public void resetCount(View view) {
        counter = 0;
        encValue.setText(String.valueOf(counter));
        currChance.setText("1/4096");
        saveData();
    }

    public void ChanceInfo(){
        if (counter <= 69) {
            currChance.setText("1/4096");
        }
        if (counter >= 70 && counter <= 255) {
            currChance.setText("1/1024");
        }
        if (counter >= 256 && counter <= 324) {
            currChance.setText("1/4096");
        }
        if (counter >= 325 && counter <= 509) {
            currChance.setText("1/1024");
        }
        if (counter >= 510 && counter <= 579) {
            currChance.setText("1/4096");
        }
        if (counter >= 580 && counter <= 764) {
            currChance.setText("1/1024");
        }
        if (counter >= 765 && counter <= 834) {
            currChance.setText("1/4096");
        }
        if (counter >= 835 && counter <= 1019) {
            currChance.setText("1/1024");
        }
}

    public void saveData() {
        SharedPreferences sC =  PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sC.edit();
        editor.putInt("counterNum", Integer.parseInt(encValue.getText().toString()));
        editor.apply();

    }

}