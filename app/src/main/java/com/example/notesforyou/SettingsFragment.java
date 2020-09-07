package com.example.notesforyou;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat {

    EditTextPreference preference;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.password_preference);
        preference = findPreference("password");
        preference.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() {
            @Override
            public void onBindEditText(@NonNull EditText editText) {
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                editText.selectAll();
                int maxLength = 4;
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
            }
        });
    }
}
