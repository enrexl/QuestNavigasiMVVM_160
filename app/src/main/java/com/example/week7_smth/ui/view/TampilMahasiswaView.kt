package com.example.week7_smth.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.week7_smth.model.Mahasiswa

@Composable
fun TampilMahasiswaView(
    mhs : Mahasiswa,
    onBackClick:() -> Unit = {}
){

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TampilData(
            judul = "Nama",
            isinya = mhs.nama
        )

        TampilData(
            judul = "NIM",
            isinya = mhs.nim
        )

        TampilData(
            judul = "Gender",
            isinya = mhs.gender

        )

        TampilData(

            judul = "Email",
            isinya = mhs.email
        )

        TampilData(

            judul = "Nomor HP",
            isinya = mhs.noHp
        )

        TampilData(

            judul = "Alamat",
            isinya = mhs.alamat
        )
        Button(
            onClick = {onBackClick()},
            modifier = Modifier.padding(20.dp),

        ) {
            Text("BACK")

        }

    }
}


@Composable
fun TampilData(
    judul:String,
    isinya:String )
{
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(judul, modifier = Modifier.weight(0.5f))
        Text(":", modifier = Modifier.weight(0.1f))
        Text(isinya, modifier = Modifier.weight(0.8f))
    }
}