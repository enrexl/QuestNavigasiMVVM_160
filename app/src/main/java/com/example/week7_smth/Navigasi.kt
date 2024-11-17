package com.example.week7_smth

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.week7_smth.model.DataJK
import com.example.week7_smth.ui.view.FormulirView
import com.example.week7_smth.ui.view.TampilMahasiswaView
import com.example.week7_smth.ui.viewModel.MahasiswaViewModel
import androidx.compose.runtime.getValue
import androidx.navigation.NavController


enum class Halaman{
    Form,
    Detail
}



@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
) {
    Scaffold { isipadding ->
        val uiState by viewModel.uistate.collectAsState()

        NavHost(
            startDestination = Halaman.Form.name,
            navController = navHost,
            modifier = modifier.padding(isipadding)

        ) {
            composable(route = Halaman.Form.name) {
                val konteks = LocalContext.current
                FormulirView(pilihanJK = DataJK.isJK.map {
                    isi -> konteks.resources.getString(isi)
                                                         },
                    onClickButton = {
                        viewModel.saveDataMahasiswa(it)
                        navHost.navigate(Halaman.Detail.name)
                    }
                )

            }
            composable(route = Halaman.Detail.name){
                TampilMahasiswaView(
                    mhs = uiState,
                    onBackClick = {navHost.popBackStack()}
                )
            }



        }
    }
}