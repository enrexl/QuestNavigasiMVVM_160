package com.example.week7_smth.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.week7_smth.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MahasiswaViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(Mahasiswa())
    val uistate: StateFlow<Mahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(
        ls : MutableList<String>
    ){
        _uiState.update { data ->
            data.copy(
                nama = ls[0],
                gender = ls[1],
                alamat = ls[2],
                email = ls[3],
                noHp = ls[4],
                nim = ls[5],
            )
        }
    }
}