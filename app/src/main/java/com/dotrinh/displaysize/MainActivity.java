package com.dotrinh.displaysize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void attachBaseContext(Context baseContext) {
        Resources res           = baseContext.getResources();
        Configuration configuration = res.getConfiguration();
        Context       newContext    = baseContext;
        configuration.fontScale = 1f;
        DisplayMetrics metrics = res.getDisplayMetrics();
        WindowManager wm = (WindowManager) baseContext.getSystemService(WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        metrics.scaledDensity = 1f;//configuration.fontScale * metrics.density;
        configuration.densityDpi = (int) metrics.xdpi;
        newContext               = baseContext.createConfigurationContext(configuration);
        super.attachBaseContext(newContext);
    }
}