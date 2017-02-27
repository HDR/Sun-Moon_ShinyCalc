package com.hdr.shinycalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ShinyCalc extends Activity {

    private CheckBox ShinyCharm;
    private TextView encValue;
    private TextView currChance;
    private int counter;
    private EditText setEncount;
    private Spinner setMode;
    private CheckBox changeTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
         boolean switchStatus = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("theme", false);
         if (switchStatus) {
            setTheme(R.style.MaterialDarkHDR);
         }
         else {
            setTheme(R.style.AppTheme);
        }
        setContentView(R.layout.activity_shiny_calc);

        encValue = (TextView) findViewById(R.id.enCounter);
        currChance = (TextView) findViewById(R.id.encChance);
        setEncount = (EditText) findViewById(R.id.setField);
        setMode = (Spinner) findViewById(R.id.modeSet);
        ShinyCharm = (CheckBox) findViewById(R.id.charm);
        changeTheme = (CheckBox) findViewById(R.id.DarkMode);

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

        boolean switchState = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("theme", false);
        changeTheme.setChecked(switchState);

        SpinnerAdapter CSpin = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, new String[]{"S.O.S", "Masuda", "Soft Reset"});
        setMode.setAdapter(CSpin);

        String getSpinner = PreferenceManager.getDefaultSharedPreferences(this).getString("CurrentMode", "S.O.S");
        ArrayAdapter<String> array_spinner = (ArrayAdapter<String>) setMode.getAdapter();
        setMode.setSelection(array_spinner.getPosition(getSpinner));

        String setString = setEncount.getText().toString();
        if (TextUtils.isEmpty(setString)) {
            return;
        }
    }

    public void increaseCount(View view) {
        counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
        if (counter != 8192) {
            counter++;
            encValue.setText(Integer.toString(counter));
            saveData();
            ChanceInfo();
        }
    }

    public void decreaseCount(View view) {
        counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
        if (counter != 0) {
            counter--;
            encValue.setText(Integer.toString(counter));
            saveData();
            ChanceInfo();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP)) {
            if (counter != 8192) {
                counter++;
                encValue.setText(Integer.toString(counter));
                saveData();
                ChanceInfo();
            }
        }
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {
            if (counter != 0) {
                counter--;
                encValue.setText(Integer.toString(counter));
                saveData();
                ChanceInfo();
            }
        }
        return true;
    }

    public void resetCount(View view) {
        counter = 0;
        encValue.setText(String.valueOf(counter));
        saveData();
        ChanceInfo();
    }

    private void ChanceInfo() {
        String getMode = setMode.getSelectedItem().toString();
        if (getMode.equals("S.O.S")) {
            ShinyCharm = (CheckBox) findViewById(R.id.charm);

            int lowBound = 0;
            int highBound = 69;

            for (int i = 0; i <= 80; i++) {
                if (i % 2 == 0) {
                    updateChanceInfo(lowBound, highBound, "1/1365", "1/4096", ShinyCharm.isChecked());
                    lowBound = highBound + 1;
                    highBound = lowBound + 185;
                } else {
                    updateChanceInfo(lowBound, highBound, "1/683", "1/1024", ShinyCharm.isChecked());
                    lowBound = highBound + 1;
                    highBound = lowBound + 69;
                }

            }

        }

        if (getMode.equals("Masuda")) {
            updateChanceInfo(0, 8192, "1/512", "1/683", ShinyCharm.isChecked());
        }
        if (getMode.equals("Soft Reset")) {
            updateChanceInfo(0, 8192, "1/1365", "1/4096", ShinyCharm.isChecked());
        }
    }

    private void updateChanceInfo(int lower_bound, int higher_bound, String chanceChecked, String chanceUnchecked, boolean shinyCharm) {
        int counter = PreferenceManager.getDefaultSharedPreferences(this).getInt("counterNum", 0);
        if (counter >= lower_bound && counter <= higher_bound) {
            if (shinyCharm) {
                currChance.setText(chanceChecked);
            } else {
                currChance.setText(chanceUnchecked);
            }
        }
    }

    private void saveData() {
        SharedPreferences sC = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sC.edit();
        editor.putInt("counterNum", Integer.parseInt(encValue.getText().toString()));
        editor.putString("CurrentMode", setMode.getSelectedItem().toString());
        editor.putBoolean("CharmStatus", ShinyCharm.isChecked());
        editor.putBoolean("theme", changeTheme.isChecked());
        editor.apply();
    }

    public void updateData(View view) {
        ChanceInfo();
        saveData();
    }

    public void setEncounters(View view) {
        setEncount.setVisibility(View.VISIBLE);
        setEncount.requestFocus();
        setEncount.setFocusableInTouchMode(true);
        InputMethodManager keyBo = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        keyBo.showSoftInput(setEncount, InputMethodManager.SHOW_IMPLICIT);
    }

    public void setField(View view) {
        if (setEncount.getText().toString().matches("")) {
            Toast.makeText(getApplicationContext(), "Error: No Value", Toast.LENGTH_SHORT).show();
        } else {
            int setEncount_num = Integer.parseInt(String.valueOf(setEncount.getText()));
            if (setEncount_num >= 8193) {
                Toast.makeText(getApplicationContext(), "Value has to be 8192 or below.", Toast.LENGTH_SHORT).show();
                InputMethodManager keyBo = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                setEncount.setText("");
                setEncount.setVisibility(View.GONE);
                keyBo.hideSoftInputFromWindow(setEncount.getWindowToken(), 0);
            } else {
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

    public void setDM(View view){
        saveData();
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}