package com.samrans.labtest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.samrans.labtest.database.dao.LabListDao
import com.samrans.labtest.responseModel.DetailList


@Database(entities = [DetailList::class],
    version = 1,
    exportSchema = false,
    views = [])
abstract class AppDatabase : RoomDatabase()  {
    abstract fun getLabListDao(): LabListDao


}