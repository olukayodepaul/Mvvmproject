package com.leventisfoods.paul.mvvmproject.model.dbtables;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insert(Register register);

    @Query("SELECT * FROM registration")
    LiveData<List<Register>> getAllNote ();
}
