package com.example.pamucp2.repository

import com.example.pamucp2.data.dao.JadwalDao
import com.example.pamucp2.data.entity.Jadwal
import kotlinx.coroutines.flow.Flow

class LocalRepositoryJdl (
    private val jadwalDao: JadwalDao
) : RepositoryJdl {
    override suspend fun insertJdl(jadwal: Jadwal) {
        jadwalDao.insertJadwal(jadwal)
    }
    override suspend fun deleteJdl(jadwal: Jadwal) {
        jadwalDao.deleteJadwal(jadwal)
    }
    override suspend fun updateJdl(jadwal: Jadwal) {
        jadwalDao.updateJadwal(jadwal)
    }
    override fun getAllJdl(): Flow<List<Jadwal>> {
        return jadwalDao.getAllJadwal()
    }
    override fun getJdl(idJdl: String): Flow<Jadwal> {
        return jadwalDao.getJadwal(idJdl)
    }
}