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
@Entity(tableName = "indonesia_english")
public class IndonesiaEnglish implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.kata);
        dest.writeString(this.keterangan);
    }

    protected IndonesiaEnglish(Parcel in) {
        this.kata = in.readString();
        this.keterangan = in.readString();
    }

    public static final Creator<IndonesiaEnglish> CREATOR = new Creator<IndonesiaEnglish>() {
        @Override
        public IndonesiaEnglish createFromParcel(Parcel source) {
            return new IndonesiaEnglish(source);
        }

        @Override
        public IndonesiaEnglish[] newArray(int size) {
            return new IndonesiaEnglish[size];
        }
    };
}
