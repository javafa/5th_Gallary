package com.kodonho.android.gallary;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    public MainActivity() {
        super(Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    @Override
    public void init() {
        setContentView(R.layout.activity_main);
    }

    public void getImage(View view){
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }
}
