package com.example.pamucp2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jadwal")
data class Jadwal(
    @PrimaryKey
    val idJdl: String,
    val namaDokter: String,
    val namaPasien: String,
    val noHp: String,
    val tanggalKonsul: String,
    val status: String
)
