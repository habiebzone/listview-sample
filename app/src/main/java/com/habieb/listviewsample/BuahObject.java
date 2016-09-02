package com.habieb.listviewsample;

/**
 * Created by akupeduli on 9/1/16.
 */
public class BuahObject {
    private String nama;
    private String berat;
    private int imageResId;

    public BuahObject(String nama, String berat, int imageResId) {
        this.nama = nama;
        this.berat = berat;
        this.imageResId = imageResId;
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

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}