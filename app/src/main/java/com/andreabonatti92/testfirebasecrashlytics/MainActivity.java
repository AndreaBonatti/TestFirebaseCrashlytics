package com.andreabonatti92.testfirebasecrashlytics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.crashlytics.CustomKeysAndValues;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exceptionBtn = findViewById(R.id.exceptionButton);
        exceptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                throw new RuntimeException("Test Crash"); // Force a crash
            }
        });

        Button noCrashBtn = findViewById(R.id.noCrashExceptionButton);
        noCrashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomKeysAndValues keysAndValues = new CustomKeysAndValues.Builder()
                        .putString("string key", "string value")
                        .putString("string key 2", "string  value 2")
                        .putBoolean("boolean key", true)
                        .putBoolean("boolean key 2", false)
                        .putFloat("float key", 1.01f)
                        .putFloat("float key 2", 2.02f)
                        .build();

                FirebaseCrashlytics.getInstance().setCustomKeys(keysAndValues);
                FirebaseCrashlytics.getInstance().setUserId("edo32554678");
                FirebaseCrashlytics.getInstance().log(Constants.TEST);
            }
        });
    }
}