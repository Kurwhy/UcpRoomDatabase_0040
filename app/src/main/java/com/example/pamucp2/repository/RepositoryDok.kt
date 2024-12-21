package com.example.pamucp2.repository

import com.example.pamucp2.data.entity.Dokter
import kotlinx.coroutines.flow.Flow

interface RepositoryDok {
    suspend fun insertDok(dokter: Dokter)

    fun getAllDok(): Flow<List<Dokter>>
}