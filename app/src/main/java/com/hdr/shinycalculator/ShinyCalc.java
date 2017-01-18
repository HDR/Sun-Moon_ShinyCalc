package com.hdr.shinycalculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ShinyCalc extends AppCompatActivity {

    CheckBox ShinyCharm;

    TextView encValue;

    TextView currChance;
    int counter;

    EditText setEncount;

    Spinner setMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiny_calc);

        encValue = (TextView) findViewById(R.id.enCounter);
        currChance = (TextView) findViewById(R.id.encChance);
        setEncount = (EditText) findViewById(R.id.setField);
        setMode = (Spinner) findViewById(R.id.modeSet);
        ShinyCharm = (CheckBox) findViewById(R.id.charm);

        setMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ChanceInfo();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        int counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
        encValue.setText(Integer.toString(counter));

        boolean charmStatus = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("CharmStatus", false);
        ShinyCharm.setChecked(charmStatus);

        String[] items = new String[]{"S.O.S", "Matsuda", "Soft Reset"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        setMode.setAdapter(adapter);
    }

    public void increaseCount(View view) {
        counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
        if (counter == 4096) {
            //Do Nothing
        }
        else if (counter >= 0){
            counter++;
            encValue.setText(Integer.toString(counter));
            saveData();
            ChanceInfo();
        }
    }

    public void decreaseCount(View view) {
        counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
        if (counter == 0) {
            //Do Nothing
        }
        else if (counter >= 1) {
            counter--;
            encValue.setText(Integer.toString(counter));
            saveData();
            ChanceInfo();
        }
    }

    public void resetCount(View view) {
        counter = 0;
        encValue.setText(String.valueOf(counter));
        saveData();
        ChanceInfo();
    }

    public void ChanceInfo() {
        String getMode = setMode.getSelectedItem().toString();
        if (getMode.equals("S.O.S")) {
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
            updateChanceInfo(3895, 4079, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(4080, 4149, "1/1365", "1/4096", ShinyCharm.isChecked());
        }
        if (getMode.equals("Matsuda")) {
            updateChanceInfo(0, 4096, "1/512", "1/683", ShinyCharm.isChecked());
        }
        if (getMode.equals("Soft Reset")) {
            updateChanceInfo(0, 4096, "1/1365", "1/4096", ShinyCharm.isChecked());
        }
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
        editor.putString("CurrentMode", setMode.getSelectedItem().toString());
        editor.putBoolean("CharmStatus", ShinyCharm.isChecked());
        editor.apply();
    }

    public void updateData(View view) {

        ChanceInfo();
        saveData();
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
        int setEncount_num = Integer.parseInt(String.valueOf(setEncount.getText()));
        if(setEncount_text.isEmpty()) {
            //do Nothing
        }
        if(setEncount_num >= 4097) {
            Toast.makeText(getApplicationContext(), "Value has to be 4096 or below.", Toast.LENGTH_SHORT).show();
            InputMethodManager keyBo = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            setEncount.setText("");
            setEncount.setVisibility(View.GONE);
            keyBo.hideSoftInputFromWindow(setEncount.getWindowToken(), 0);
        }
        else {
            setEncount.getText();
            encValue.setText(String.valueOf(setEncount.getText()));
            saveData();
            ChanceInfo();
            setEncount.setVisibility(View.GONE);
            setEncount.setText("");
            InputMethodManager keyBo = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            keyBo.hideSoftInputFromWindow(setEncount.getWindowToken(), 0);
        }

    }




}