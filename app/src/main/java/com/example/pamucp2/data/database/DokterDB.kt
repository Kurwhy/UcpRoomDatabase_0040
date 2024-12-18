package com.example.pamucp2.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pamucp2.data.dao.DokterDao
import com.example.pamucp2.data.entity.Dokter

@Database(entities = [Dokter::class], version = 1, exportSchema = false)
abstract class DokterDB : RoomDatabase() {

    // Mendefinisikan fungsi untuk mengakses data Mahasiswa
    abstract fun dokterDao(): DokterDao

    companion object {
        @Volatile // Memasitikan bahwa nilai variable Instance selalu sama di semua
        private var Instance: DokterDB? = null

        fun getDatabase(context: Context): DokterDB {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    DokterDB::class.java,
                    "DokterDB"
                )
                    .build().also { Instance = it }
            })
        }
    }
}
