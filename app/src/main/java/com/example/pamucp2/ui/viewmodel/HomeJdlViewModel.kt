package com.example.pamucp2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamucp2.data.entity.Jadwal
import com.example.pamucp2.repository.RepositoryJdl
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class HomeJdlViewModel(
    private val repositoryJdl: RepositoryJdl
): ViewModel() {
    val homeUiState: StateFlow<HomeUiStateJdl> = repositoryJdl.getAllJdl()
        .filterNotNull()
        .map {
            HomeUiStateJdl(
                listJdl = it.toList(),
                isLoading = false,
            )
        }
        .onStart {
            emit(HomeUiStateJdl(isLoading = true))
            delay(900)
        }
        .catch {
            emit(
                HomeUiStateJdl(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi Kesalahan"
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = HomeUiStateJdl(
                isLoading = true,
            )
        )
}

data class HomeUiStateJdl(
    val listJdl: List<Jadwal> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)