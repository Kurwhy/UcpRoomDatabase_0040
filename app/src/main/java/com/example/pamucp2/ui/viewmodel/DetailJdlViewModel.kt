package com.example.pamucp2.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamucp2.data.entity.Jadwal
import com.example.pamucp2.repository.RepositoryJdl
import com.example.pamucp2.ui.navigation.DestinasiDetail
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DetailJdlViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoryJdl: RepositoryJdl,
) : ViewModel(){
    private val _idJdl: String = checkNotNull(savedStateHandle[DestinasiDetail.IDJDL])

    val detailUiState: StateFlow<DetailUiState> = repositoryJdl.getJdl(_idJdl)
        .filterNotNull()
        .map {
            DetailUiState(
                detailUiEvent = it.toDetailUiEvent(),
                isLoading = false
            )
        }
        .onStart {
            emit(DetailUiState(isLoading = true))
            delay(600)
        }
        .catch {
            emit(
                DetailUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi Kesalahan",
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(2000),
            initialValue = DetailUiState (
                isLoading = true,
            ),
        )

    fun deteleJdl() {
        detailUiState.value.detailUiEvent.toJadwalEntity().let {
            viewModelScope.launch {
                repositoryJdl.deleteJdl(it)
            }
        }
    }
}

data class DetailUiState(
    val detailUiEvent: JadwalEvent = JadwalEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
) {
    val isUiEventEmpty: Boolean
        get() = detailUiEvent == JadwalEvent()

    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != JadwalEvent()
}

fun Jadwal.toDetailUiEvent() : JadwalEvent {
    return JadwalEvent(
        idJdl = idJdl,
        namaDokter = namaDokter,
        namaPasien = namaPasien,
        noHp = noHp,
        tanggalKonsul = tanggalKonsul,
        status = status
    )
}