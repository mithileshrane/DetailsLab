package com.samrans.labtest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.samrans.labtest.responseModel.DetailList

@Dao
interface LabListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllLabs(quotes: List<DetailList>)

    @Query("SELECT * FROM DetailList")
    fun getLabs(): LiveData<List<DetailList>>

}