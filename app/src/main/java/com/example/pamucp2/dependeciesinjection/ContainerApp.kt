package com.example.pamucp2.dependeciesinjection

import android.content.Context
import com.example.pamucp2.data.database.RumahSakitDB
import com.example.pamucp2.repository.LocalRepositoryDok
import com.example.pamucp2.repository.LocalRepositoryJdl
import com.example.pamucp2.repository.RepositoryDok
import com.example.pamucp2.repository.RepositoryJdl


interface InterfaceContainerApp {
    val repositoryDok: RepositoryDok
    val repositoryJdl: RepositoryJdl
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryDok: RepositoryDok by lazy {
        LocalRepositoryDok(RumahSakitDB.getDatabase(context).dokterDao())
    }
    override val repositoryJdl: RepositoryJdl by lazy {
        LocalRepositoryJdl(RumahSakitDB.getDatabase(context).jadwalDao())
    }
}