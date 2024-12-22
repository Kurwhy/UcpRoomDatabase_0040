package com.example.pamucp2.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pamucp2.data.dao.DokterDao
import com.example.pamucp2.data.dao.JadwalDao
import com.example.pamucp2.data.entity.Dokter
import com.example.pamucp2.data.entity.Jadwal

@Database(entities = [Dokter::class,Jadwal::class], version = 1, exportSchema = false)
abstract class RumahSakitDB : RoomDatabase() {

    abstract fun dokterDao(): DokterDao
    abstract fun jadwalDao(): JadwalDao

    companion object {
        @Volatile
        private var Instance: RumahSakitDB? = null

        fun getDatabase(context: Context): RumahSakitDB {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    RumahSakitDB::class.java,
                    "RumahSakit"
                )
                    .build().also { Instance = it }
            })
        }
    }
}
