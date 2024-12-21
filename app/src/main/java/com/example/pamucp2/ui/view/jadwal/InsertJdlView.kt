package com.example.pamucp2.ui.view.jadwal

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pamucp2.ui.costumwidget.TopAppBar
import com.example.pamucp2.ui.navigation.AlamatNavigasi
import com.example.pamucp2.ui.viewmodel.*
import kotlinx.coroutines.launch

object DestinasiInsertJdl : AlamatNavigasi {
    override val route: String = "insert_jdl"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun InsertJdlViewPreview() {
    InsertJdlView(onBack = {}, onNavigate = {})
}

@Composable
fun InsertJdlView(
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: JadwalViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val uiState = viewModel.uiState
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(uiState.snackBarMessage) {
        uiState.snackBarMessage?.let { message ->
            coroutineScope.launch {
                snackbarHostState.showSnackbar(message)
                viewModel.resetSnackBarMessage()
            }
        }
    }

    Scaffold(
        modifier = Modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            TopAppBar(
                onBack = onBack,
                showBackButton = true,
                judul = "Tambah Jadwal"
            )
            InsertBodyJdl(
                uiState = uiState,
                onValueChange = { updateEvent ->
                    viewModel.updateState(updateEvent)
                },
                onClick = {
                    coroutineScope.launch {
                        viewModel.saveData()
                    }
                    onNavigate()
                }
            )
        }
    }
}

@Composable
@Preview
fun InsertBodyJdlPreview() {
    InsertBodyJdl(
        uiState = JdlUIState(),
        onValueChange = {},
        onClick = {}
    )
}

@Composable
fun InsertBodyJdl(
    modifier: Modifier = Modifier,
    onValueChange: (JadwalEvent) -> Unit,
    uiState: JdlUIState,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Form Tambah Dokter",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                InputField(
                    label = "Nama Pasien",
                    value = uiState.jadwalEvent.namaPasien,
                    error = uiState.isEntryValid.namaPasien,
                    onValueChange = { onValueChange(uiState.jadwalEvent.copy(namaPasien = it)) }
                )
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                InputField(
                    label = "ID Jadwal",
                    value = uiState.jadwalEvent.idJdl,
                    error = uiState.isEntryValid.idJdl,
                    onValueChange = { onValueChange(uiState.jadwalEvent.copy(idJdl = it)) }
                )
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                InputField(
                    label = "Nama Dokter",
                    value = uiState.jadwalEvent.namaDokter,
                    error = uiState.isEntryValid.namaDokter,
                    onValueChange = { onValueChange(uiState.jadwalEvent.copy(namaDokter = it)) }
                )
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                InputField(
                    label = "No Hp",
                    value = uiState.jadwalEvent.noHp,
                    error = uiState.isEntryValid.noHp,
                    onValueChange = { onValueChange(uiState.jadwalEvent.copy(noHp = it)) }
                )
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                InputField(
                    label = "Tanggal Konsul",
                    value = uiState.jadwalEvent.tanggalKonsul,
                    error = uiState.isEntryValid.tanggalKonsul,
                    onValueChange = { onValueChange(uiState.jadwalEvent.copy(tanggalKonsul = it)) }
                )
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                InputField(
                    label = "Status",
                    value = uiState.jadwalEvent.status,
                    error = uiState.isEntryValid.status,
                    onValueChange = { onValueChange(uiState.jadwalEvent.copy(status = it)) }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Simpan", style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
fun InputField(
    label: String,
    value: String,
    error: String?,
    onValueChange: (String) -> Unit
) {
    Column {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            isError = error != null,
            singleLine = true
        )
        if (error != null) {
            Text(
                text = error,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}