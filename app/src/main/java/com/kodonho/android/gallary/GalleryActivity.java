package com.kodonho.android.gallary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kodonho.android.gallary.adapter.GalleryAdapter;
import com.kodonho.android.gallary.domain.Item;
import com.kodonho.android.gallary.domain.Loader;

import java.util.List;

public class GalleryActivity extends AppCompatActivity implements GalleryAdapter.Callback {
    RecyclerView recyclerView;
    GalleryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        recyclerView = findViewById(R.id.recyclerView);
        List<Item> data = Loader.getGalleryItem(this);
        adapter = new GalleryAdapter(data, this);
        recyclerView.setAdapter(adapter);
        // GridLayoutManager -> 세로줄의 수를 조정할 수 있다
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
    }

    public static final String KEY_PATH = "imagepath";

    @Override
    public void returnImagePath(String imagePath) {
        Intent intent = new Intent();
        intent.putExtra(KEY_PATH, imagePath);
        setResult(RESULT_OK, intent);
        finish();
    }
}
