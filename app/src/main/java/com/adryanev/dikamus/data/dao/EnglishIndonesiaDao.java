package com.adryanev.dikamus.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.adryanev.dikamus.data.entity.EnglishIndonesia;

import java.util.List;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 3:55 PM
 */
@Dao
public interface EnglishIndonesiaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(EnglishIndonesia englishIndonesa);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertList(List<EnglishIndonesia> list);

    @Query("DELETE From english_indonesia")
    void deleteAll();

    @Query("Select * from english_indonesia ORDER by kata ASC")
    LiveData<List<EnglishIndonesia>> getAll();

    @Query("SELECT * from english_indonesia WHERE kata LIKE :kata")
    LiveData<List<EnglishIndonesia>> search(String kata);

    @Query("SELECT * from english_indonesia Where kata = :kata")
    LiveData<EnglishIndonesia> getTerjemahan(String kata);

}
