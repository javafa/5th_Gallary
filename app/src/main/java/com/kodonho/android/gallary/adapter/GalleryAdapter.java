package com.kodonho.android.gallary.adapter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kodonho.android.gallary.R;
import com.kodonho.android.gallary.domain.Item;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.Holder>{
    List<Item> data;
    public GalleryAdapter(List<Item> data){
        this.data = data;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Item item = data.get(position);
        holder.setImage(item.imagePath);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView image;
        Item item;
        public Holder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
        }
        public void setImage(String imagePath){
            Uri uri = Uri.parse(imagePath);
            image.setImageURI(uri);
        }
    }
}