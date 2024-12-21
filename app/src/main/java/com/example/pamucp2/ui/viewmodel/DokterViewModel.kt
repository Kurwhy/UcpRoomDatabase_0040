package com.example.pamucp2.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamucp2.data.entity.Dokter
import com.example.pamucp2.repository.RepositoryDok
import kotlinx.coroutines.launch

data class DokterEvent(
    val idDok: String = "",
    val nama: String = "",
    val spesialis: String = "",
    val klinik: String = "",
    val noHp: String = "",
    val jamKerja: String = "",

    )

class DokterViewModel(
    private val repositoryDok: RepositoryDok
) : ViewModel() {

    var uiState by mutableStateOf(DokUIState())

    fun updateState(DokterEvent: DokterEvent) {
        uiState = uiState.copy(
            dokterEvent = DokterEvent,
        )
    }
    private fun validateField(): Boolean {
        val event = uiState.dokterEvent
        val errorState = FormErrorStateDok(
            idDok = if (event.idDok.isNotEmpty()) null else "idDok tidak boleh kosong",
            nama = if (event.nama.isNotEmpty()) null else "nama tidak boleh kosong",
            spesialis = if (event.spesialis.isNotEmpty()) null else "spesialis tidak boleh kosong",
            klinik = if (event.klinik.isNotEmpty()) null else "klinik tidak boleh kosong",
            noHp = if (event.noHp.isNotEmpty()) null else "noHp tidak boleh kosong",
            jamKerja = if (event.jamKerja.isNotEmpty()) null else "jamKerja tidak boleh kosong",
        )

        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    fun saveData() {
        val currentEvent = uiState.dokterEvent

        if (validateField()) {
            viewModelScope.launch {
                try{
                    repositoryDok.insertDok(currentEvent.toDokterEntity())
                    uiState = uiState.copy(
                        snackBarMessage =  "Data berhasil disimpan",
                        dokterEvent = DokterEvent(),
                        isEntryValid = FormErrorStateDok()
                    )
                } catch (e: Exception) {
                    uiState = uiState.copy(
                        snackBarMessage = "Data gagal disimpan"
                    )
                }
            }
        } else {
            uiState = uiState.copy(
                snackBarMessage = "Input tidak valid. Periksa kembali data anda."
            )
        }
    }

    fun resetSnackBarMessage() {
        uiState = uiState.copy(snackBarMessage = null)
    }
}

data class DokUIState(
    val dokterEvent: DokterEvent = DokterEvent(),
    val isEntryValid: FormErrorStateDok = FormErrorStateDok(),
    val snackBarMessage: String? = null,
)

data class FormErrorStateDok(
    val idDok: String? = null,
    val nama: String? = null,
    val spesialis: String? = null,
    val klinik: String? = null,
    val noHp: String? = null,
    val jamKerja: String? = null
) {
    fun isValid(): Boolean {
        return idDok == null
                && nama == null
                && spesialis == null
                && klinik == null
                && noHp == null
                && jamKerja == null
    }
}

fun DokterEvent.toDokterEntity(): Dokter = Dokter(
    idDok = idDok,
    nama = nama,
    spesialis = spesialis,
    klinik = klinik,
    noHp = noHp,
    jamKerja = jamKerja
)