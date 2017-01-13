package com.hdr.shinycalculator;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class ShinyCalc extends AppCompatActivity {

    CheckBox ShinyCharm;

    TextView encValue;

    TextView currChance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiny_calc);

        encValue = (TextView) findViewById(R.id.enCounter);
        currChance = (TextView) findViewById(R.id.encChance);

        int counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
        encValue.setText(Integer.toString(counter));

        Spinner dropdown = (Spinner) findViewById(R.id.modeSet);
        String[] items = new String[]{"S.O.S", "Matsuda", "Soft Reset"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void increaseCount(View view) {
        int counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
        counter++;
        encValue.setText(Integer.toString(counter));
        ChanceInfo();
        saveData();
    }

    public void decreaseCount(View view) {
        int counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
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
        int counter;
        counter = 0;
        encValue.setText(String.valueOf(counter));
        saveData();
    }

    public void ChanceInfo(){
        int counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
        ShinyCharm = (CheckBox) findViewById(R.id.charm);
        if (counter <= 69 && !ShinyCharm.isChecked()) {
            currChance.setText("1/4096");
        }
        if (counter <= 69 && ShinyCharm.isChecked()) {
            currChance.setText("1/1365");
        }

        updateChanceInfo(70, 255, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(256, 324, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(325, 509, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(510, 579, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(580, 764, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(765, 834, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(835, 1019, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(1020, 1089, "1/1365", "1/4096", ShinyCharm.isChecked());
    }

    private void updateChanceInfo(int lower_bound, int higher_bound, String chanceChecked, String chanceUnchecked, boolean shinyCharm) {
        int counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
        if (counter >= lower_bound && counter <= higher_bound ) {
            if (shinyCharm) {
                currChance.setText(chanceChecked);
            } else {
                currChance.setText(chanceUnchecked);
            }
        }
    }

    public void saveData() {
        SharedPreferences sC =  PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sC.edit();
        editor.putInt("counterNum", Integer.parseInt(encValue.getText().toString()));
        editor.apply();
    }

    public void updateData(View view) {
        ChanceInfo();
    }

    

}