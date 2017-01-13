package com.hdr.shinycalculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ShinyCalc extends AppCompatActivity {

    CheckBox ShinyCharm;

    TextView encValue;

    TextView currChance;

    EditText setEncount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiny_calc);

        encValue = (TextView) findViewById(R.id.enCounter);
        currChance = (TextView) findViewById(R.id.encChance);
        setEncount = (EditText) findViewById(R.id.setField);

        int counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
        encValue.setText(Integer.toString(counter));

        Spinner dropdown = (Spinner) findViewById(R.id.modeSet);
        String[] items = new String[]{"S.O.S", "Matsuda", "Soft Reset"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void increaseCount(View view) {
        int counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
        if (counter == 4096) {
            //Do Nothing
        }
        else if (counter >= 0){
            counter++;
            encValue.setText(Integer.toString(counter));
            ChanceInfo();
            saveData();
        }
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
        updateChanceInfo(1090, 1274, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(1275, 1344, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(1345, 1549, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(1530, 1599, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(1600, 1784, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(1785, 1854, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(1855, 2039, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(2040, 2109, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(2110, 2294, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(2295, 2364, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(2365, 2549, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(2550, 2619, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(2620, 2804, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(2805, 2874, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(2875, 3059, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(3060, 3129, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(3130, 3314, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(3315, 3384, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(3385, 3569, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(3570, 3639, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(3640, 3824, "1/683", "1/1024", ShinyCharm.isChecked());
        updateChanceInfo(3825, 3894, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(3895, 4079, "1/1365", "1/4096", ShinyCharm.isChecked());
        updateChanceInfo(4080, 4149, "1/1365", "1/4096", ShinyCharm.isChecked());
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

    public void setEncounters(View view){
        setEncount.setVisibility(View.VISIBLE);
        setEncount.requestFocus();
        setEncount.setFocusableInTouchMode(true);
        InputMethodManager keyBo = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        keyBo.showSoftInput(setEncount, InputMethodManager.SHOW_IMPLICIT);
    }

    public void setField(View view) {
        String setEncount_text = setEncount.getText().toString().trim();
        if(setEncount_text.isEmpty()) {
            //do Nothing
         }
        else {
            setEncount.getText();
            encValue.setText(String.valueOf(setEncount.getText()));
            saveData();
            setEncount.setVisibility(View.GONE);
            setEncount.setText("");
            InputMethodManager keyBo = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            keyBo.hideSoftInputFromWindow(setEncount.getWindowToken(), 0);
        }

    }


    

}