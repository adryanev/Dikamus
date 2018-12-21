package com.adryanev.dikamus.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(EnglishIndonesia englishIndonesa);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
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
