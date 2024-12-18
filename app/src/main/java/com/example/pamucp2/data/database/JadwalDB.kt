package com.example.pamucp2.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pamucp2.data.dao.JadwalDao
import com.example.pamucp2.data.entity.Jadwal

@Database(entities = [Jadwal::class], version = 1, exportSchema = false)
abstract class JadwalDB : RoomDatabase() {

    abstract fun jadwalDao(): JadwalDao

    companion object {
        @Volatile // Memasitikan bahwa nilai variable Instance selalu sama di semua
        private var Instance: JadwalDB? = null

        fun getDatabase(context: Context): JadwalDB {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    JadwalDB::class.java,
                    "JadawalDB"
                )
                    .build().also { Instance = it }
            })
        }
    }
}
