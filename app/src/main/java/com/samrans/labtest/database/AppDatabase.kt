package com.samrans.labtest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.samrans.labtest.database.dao.LabListDao
import com.samrans.labtest.responseModel.DetailList


@Database(entities = [DetailList::class],
    version = 1,
    exportSchema = false,
    views = [])
abstract class AppDatabase : RoomDatabase()  {
    abstract fun getLabListDao(): LabListDao
    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(
            LOCK
        ) {
            instance
                ?: buildDatabase(context).also {
                    instance = it
                }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).build()
    }

}