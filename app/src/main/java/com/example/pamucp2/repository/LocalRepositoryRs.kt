package com.example.pamucp2.repository

import com.example.pamucp2.data.dao.DokterDao
import com.example.pamucp2.data.dao.JadwalDao
import com.example.pamucp2.data.entity.Dokter
import com.example.pamucp2.data.entity.Jadwal
import kotlinx.coroutines.flow.Flow

class LocalRepositoryRs (
    private val dokterDao: DokterDao,
    private val jadwalDao: JadwalDao

) : RepositoryRs {
    override suspend fun insertDok(dokter: Dokter) {
        dokterDao.insertDokter(dokter)
    }
    override fun getAllDok(): Flow<List<Dokter>> {
        return dokterDao.getAllDokter()
    }

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
    override fun getJdl(idJdl: Int): Flow<Jadwal> {
        return jadwalDao.getJadwal(idJdl)
    }
}