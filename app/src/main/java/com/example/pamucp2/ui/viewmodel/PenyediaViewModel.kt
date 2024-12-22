package com.example.pamucp2.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pamucp2.RsApp

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            DokterViewModel(
                rsApp().containerApp.repositoryRs
            )
        }
        initializer {
            HomeDokViewModel(
                rsApp().containerApp.repositoryRs
            )
        }
        initializer {
            JadwalViewModel(
                rsApp().containerApp.repositoryRs
            )
        }
        initializer {
            HomeJdlViewModel(
                rsApp().containerApp.repositoryRs
            )
        }
        initializer {
            DetailJdlViewModel(
                createSavedStateHandle(),
                rsApp().containerApp.repositoryRs
            )
        }
        initializer {
            UpdateJdlViewModel(
                createSavedStateHandle(),
                rsApp().containerApp.repositoryRs
            )
        }
    }
}

fun CreationExtras.rsApp(): RsApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RsApp)