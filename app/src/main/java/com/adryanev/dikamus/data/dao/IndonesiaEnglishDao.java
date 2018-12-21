package com.adryanev.dikamus.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.adryanev.dikamus.data.entity.IndonesiaEnglish;

import java.util.List;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 3:55 PM
 */
@Dao
public interface IndonesiaEnglishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(IndonesiaEnglish indonesiaEnglish);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertList(List<IndonesiaEnglish> list);

    @Query("DELETE From indonesia_english")
    void deleteAll();

    @Query("Select * from indonesia_english ORDER by kata ASC")
    LiveData<List<IndonesiaEnglish>> getAll();

    @Query("SELECT * from indonesia_english WHERE kata LIKE :kata")
    LiveData<List<IndonesiaEnglish>> search(String kata);

    @Query("SELECT * from indonesia_english Where kata = :kata")
    LiveData<IndonesiaEnglish> getTerjemahan(String kata);
}
