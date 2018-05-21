package com.kodonho.android.gallary;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends BaseActivity {

    public MainActivity() {
        super(Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    @Override
    public void init() {
        setContentView(R.layout.activity_main);
    }
}
