package com.example.pamucp2.dependeciesinjection

import android.content.Context
import com.example.pamucp2.data.database.RumahSakitDB
import com.example.pamucp2.repository.LocalRepositoryRs
import com.example.pamucp2.repository.RepositoryRs


interface InterfaceContainerApp {
    val repositoryRs: RepositoryRs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryRs: RepositoryRs by lazy {
        LocalRepositoryRs(RumahSakitDB.getDatabase(context).dokterDao(),
            RumahSakitDB.getDatabase(context).jadwalDao())
    }
}