package com.kodonho.android.gallary.domain;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class Loader {

    // 폰에 있는 이미지 목록을 리턴
    public List<Item> getGalleryItem(Context context){
        List<Item> result = new ArrayList<>();
        ContentResolver resolver = context.getContentResolver();
        Uri uri_thumb = MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
        String projections_thumb[] = {MediaStore.Images.Thumbnails.DATA};
        Cursor cursor = resolver.query(uri_thumb, projections_thumb, null, null, null);
        if(cursor != null){
            while(cursor.moveToNext()){
                Item item = new Item();
                item.imagePath = cursor.getString(0);
                result.add(item);
            }
            cursor.close();
        }
//        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
//        String projections[] = {MediaStore.Images.Media.DATA};
        return result;
    }
}
