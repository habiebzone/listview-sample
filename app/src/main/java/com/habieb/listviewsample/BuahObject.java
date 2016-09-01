package com.habieb.listviewsample;

import android.graphics.drawable.Drawable;

/**
 * Created by akupeduli on 9/1/16.
 */
public class BuahObject {
    private String nama;
    private String berat;
    private Drawable imageDrawable;

    public BuahObject(String nama, String berat, Drawable imageDrawable) {
        this.nama = nama;
        this.berat = berat;
        this.imageDrawable = imageDrawable;
    }

    String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }

    public Drawable getImageImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(Drawable imageDrawable) {
        this.imageDrawable = imageDrawable;
    }
}
