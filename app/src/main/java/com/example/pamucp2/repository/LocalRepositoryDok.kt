package com.example.pamucp2.repository

import com.example.pamucp2.data.dao.DokterDao
import com.example.pamucp2.data.entity.Dokter
import kotlinx.coroutines.flow.Flow

class LocalRepositoryDok (
    private val dokterDao: DokterDao
) : RepositoryDok {
    override suspend fun insertDok(dokter: Dokter) {
        dokterDao.insertDokter(dokter)
    }
    override fun getAllDok(): Flow<List<Dokter>> {
        return dokterDao.getAllDokter()
    }
}