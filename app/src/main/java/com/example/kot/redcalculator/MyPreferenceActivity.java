package com.example.kot.redcalculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Kot Kot on 19.04.2017.
 */

public class MyPreferenceActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);




    }

    @Override
    protected void onResume() {
        super.onResume();
      //  Context myContext = getApplicationContext();
      //  SharedPreferences mySP = PreferenceManager.getDefaultSharedPreferences(myContext);
      //  mySP.registerOnSharedPreferenceChangeListener(this);

      //  float myTextSize =Float.parseFloat(mySP.getString(getString(R.string.text_sizes), "30"));

        //Toast myToast = Toast.makeText(getApplicationContext(), String.valueOf(myTextSize), Toast.LENGTH_LONG);
        //myToast.show();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {


    }
}
