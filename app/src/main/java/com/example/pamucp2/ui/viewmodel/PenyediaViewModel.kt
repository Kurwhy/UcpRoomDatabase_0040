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
                rsApp().containerApp.repositoryDok
            )
        }
        initializer {
            HomeDokViewModel(
                rsApp().containerApp.repositoryDok
            )
        }
        initializer {
            JadwalViewModel(
                rsApp().containerApp.repositoryJdl
            )
        }
        initializer {
            HomeJdlViewModel(
                rsApp().containerApp.repositoryJdl
            )
        }
        initializer {
            DetailJdlViewModel(
                createSavedStateHandle(),
                rsApp().containerApp.repositoryJdl
            )
        }
        initializer {
            UpdateJdlViewModel(
                createSavedStateHandle(),
                rsApp().containerApp.repositoryJdl
            )
        }
    }
}

fun CreationExtras.rsApp(): RsApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RsApp)