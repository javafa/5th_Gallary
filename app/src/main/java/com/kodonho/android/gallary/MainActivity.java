package com.kodonho.android.gallary;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends BaseActivity {
    public static final int REQ_GALLERY  = 99;
    ImageView imageView;

    public MainActivity() {
        super(Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    @Override
    public void init() {
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
    }

    public void getImage(View view){
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivityForResult(intent, REQ_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            switch (requestCode){
                case REQ_GALLERY:
                    String imagePath = data.getStringExtra(GalleryActivity.KEY_PATH);
                    Uri uri = Uri.parse(imagePath);
                    imageView.setImageURI(uri);
                    break;
            }
        }
    }
}
