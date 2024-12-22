package com.example.pamucp2.repository

import com.example.pamucp2.data.entity.Dokter
import com.example.pamucp2.data.entity.Jadwal
import kotlinx.coroutines.flow.Flow

interface RepositoryRs {
    suspend fun insertJdl(jadwal: Jadwal)

    suspend fun deleteJdl(jadwal: Jadwal)

    suspend fun updateJdl(jadwal: Jadwal)

    fun getAllJdl(): Flow<List<Jadwal>>

    fun getJdl(idJdl: Int): Flow<Jadwal>


    suspend fun insertDok(dokter: Dokter)

    fun getAllDok(): Flow<List<Dokter>>
}