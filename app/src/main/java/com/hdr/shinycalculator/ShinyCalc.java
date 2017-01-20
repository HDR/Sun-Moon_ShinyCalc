package com.hdr.shinycalculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
                saveData();
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

        String getSpinner = PreferenceManager.getDefaultSharedPreferences(this).getString("CurrentMode", "S.O.S");
        ArrayAdapter<String> array_spinner=(ArrayAdapter<String>)setMode.getAdapter();
        setMode.setSelection(array_spinner.getPosition(getSpinner));

        String setString = setEncount.getText().toString();
        if (TextUtils.isEmpty(setString)) {
            return;
        }

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
            updateChanceInfo(256, 325, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(326, 510, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(511, 580, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(581, 765, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(766, 835, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(836, 1020, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(1021, 1090, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(1091, 1275, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(1276, 1345, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(1346, 1530, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(1531, 1600, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(1601, 1785, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(1786, 1855, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(1856, 2040, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(2041, 2110, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(2111, 2295, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(2296, 2365, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(2366, 2550, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(2551, 2620, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(2621, 2805, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(2806, 2875, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(2876, 3060, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(3061, 3130, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(3131, 3315, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(3316, 3385, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(3386, 3570, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(3571, 3640, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(3641, 3825, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(3826, 3895, "1/1365", "1/4096", ShinyCharm.isChecked());
            updateChanceInfo(3896, 4080, "1/683", "1/1024", ShinyCharm.isChecked());
            updateChanceInfo(4081, 4150, "1/1365", "1/4096", ShinyCharm.isChecked());
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
        if (setEncount.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(), "Error: No Value", Toast.LENGTH_SHORT).show();
        }
        else {
            int setEncount_num = Integer.parseInt(String.valueOf(setEncount.getText()));
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




}
