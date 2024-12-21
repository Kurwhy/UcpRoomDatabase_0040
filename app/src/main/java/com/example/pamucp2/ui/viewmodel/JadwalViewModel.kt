package com.example.pamucp2.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamucp2.data.entity.Jadwal
import com.example.pamucp2.repository.RepositoryJdl
import kotlinx.coroutines.launch

data class JadwalEvent(
    val idJdl: String = "",
    val namaDokter: String = "",
    val namaPasien: String = "",
    val noHp: String = "",
    val tanggalKonsul: String = "",
    val status: String = "",

)

class JadwalViewModel(
    private val repositoryJdl: RepositoryJdl
) : ViewModel() {

    var uiState by mutableStateOf(JdlUIState())

    fun updateState(JadwalEvent: JadwalEvent) {
        uiState = uiState.copy(
            jadwalEvent = JadwalEvent,
        )
    }
    private fun validateField(): Boolean {
        val event = uiState.jadwalEvent
        val errorState = FormErrorStateJdl(
            idJdl = if (event.idJdl.isNotEmpty()) null else "idJdl tidak boleh kosong",
            namaDokter = if (event.namaDokter.isNotEmpty()) null else "namaDokter tidak boleh kosong",
            namaPasien = if (event.namaPasien.isNotEmpty()) null else "namaPasien tidak boleh kosong",
            noHp = if (event.noHp.isNotEmpty()) null else "noHp tidak boleh kosong",
            tanggalKonsul = if (event.tanggalKonsul.isNotEmpty()) null else "tanggalKonsul tidak boleh kosong",
            status = if (event.status.isNotEmpty()) null else "status tidak boleh kosong",
        )

        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    fun saveData() {
        val currentEvent = uiState.jadwalEvent

        if (validateField()) {
            viewModelScope.launch {
                try{
                    repositoryJdl.insertJdl(currentEvent.toJadwalEntity())
                    uiState = uiState.copy(
                        snackBarMessage =  "Data berhasil disimpan",
                        jadwalEvent = JadwalEvent(),
                        isEntryValid = FormErrorStateJdl()
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

data class JdlUIState(
    val jadwalEvent: JadwalEvent = JadwalEvent(),
    val isEntryValid: FormErrorStateJdl = FormErrorStateJdl(),
    val snackBarMessage: String? = null,
)

data class FormErrorStateJdl(
    val idJdl: String? = null,
    val namaDokter: String? = null,
    val namaPasien: String? = null,
    val noHp: String? = null,
    val tanggalKonsul: String? = null,
    val status: String? = null
) {
    fun isValid(): Boolean {
        return idJdl == null
                && namaDokter == null
                && namaPasien == null
                && noHp == null
                && tanggalKonsul == null
                && status == null
    }
}

fun JadwalEvent.toJadwalEntity(): Jadwal = Jadwal(
    idJdl = idJdl,
    namaDokter = namaDokter,
    namaPasien = namaPasien,
    noHp = noHp,
    tanggalKonsul = tanggalKonsul,
    status = status
)
