package com.adryanev.dikamus.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 3:46 PM
 */
@Entity(tableName = "indonesia_english")
public class IndonesiaEnglish {
    @PrimaryKey
    @NonNull
    private String kata;

    private String keterangan;

    public IndonesiaEnglish(@NonNull String kata, String keterangan) {
        this.kata = kata;
        this.keterangan = keterangan;
    }

    public IndonesiaEnglish() {
    }

    public String getKata() {
        return kata;
    }

    public void setKata(@NonNull String kata) {
        this.kata = kata;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(@NonNull String keterangan) {
        this.keterangan = keterangan;
    }
}
