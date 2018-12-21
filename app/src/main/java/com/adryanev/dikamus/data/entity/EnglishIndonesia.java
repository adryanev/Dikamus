package com.adryanev.dikamus.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 3:46 PM
 */
@Entity(tableName = "english_indonesia")
public class EnglishIndonesia implements Parcelable {
    @PrimaryKey
    @NonNull
    private String kata;

    public EnglishIndonesia() {
    }

    public EnglishIndonesia(@NonNull String kata, String keterangan) {
        this.kata = kata;
        this.keterangan = keterangan;
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

    private String keterangan;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.kata);
        dest.writeString(this.keterangan);
    }

    protected EnglishIndonesia(Parcel in) {
        this.kata = in.readString();
        this.keterangan = in.readString();
    }

    public static final Creator<EnglishIndonesia> CREATOR = new Creator<EnglishIndonesia>() {
        @Override
        public EnglishIndonesia createFromParcel(Parcel source) {
            return new EnglishIndonesia(source);
        }

        @Override
        public EnglishIndonesia[] newArray(int size) {
            return new EnglishIndonesia[size];
        }
    };
}
