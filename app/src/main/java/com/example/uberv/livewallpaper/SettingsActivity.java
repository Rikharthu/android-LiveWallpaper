package com.example.uberv.livewallpaper;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.widget.Toast;


public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO refactor to use fragments (this is deprecated)
        addPreferencesFromResource(R.xml.prefs);

        // add a validator to the "numberOfCircles" preference so that it only accepts numbers
        Preference circlePreference = getPreferenceScreen().findPreference("numberOfCircles");
        // ad the validator
        circlePreference.setOnPreferenceChangeListener(numberCheckListener);
    }

    /**
     * Checks that a preference is a valid numerical value
     */
    Preference.OnPreferenceChangeListener numberCheckListener = new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            // check that the string is an integer
            if (newValue != null && newValue.toString().length() > 0
                    && newValue.toString().matches("\\d*")) {
                // return true => allow preference to be changed
                // return true => allow preference to be changed
                return true;
            }
            // If not create a message to the user
            Toast.makeText(SettingsActivity.this, "Invalid Input",
                    Toast.LENGTH_SHORT).show();
            return false;

        }
    };
}
