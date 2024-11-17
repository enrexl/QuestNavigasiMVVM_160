package com.example.week7_smth.ui.view



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showBackground = true)
@Composable
fun FormulirView(modifier: Modifier= Modifier,
              pilihanJK : List<String>    ,
              onClickButton:(MutableList<String>)-> Unit ) { //nama fungsi pertama harus sesuai nama file



    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jk by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var wrapData: MutableList<String> = mutableListOf(nama,jk,alamat,email,noHp,nim)

    Column(
        Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Text(
            text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.padding(20.dp))

        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            placeholder = { Text("Masukan Nama Anda") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        TextField(
            value = nim,
            onValueChange = { nim = it },
            label = { Text("NIM") },
            placeholder = { Text("Masukan NIM Anda") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Row {
            pilihanJK.forEach() { selectedJk ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = jk == selectedJk,
                        onClick = {
                            jk = selectedJk
                        })
                    Text(selectedJk)

                }

            }
        }

        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            placeholder = { Text("Masukan Email Anda") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = noHp,
            onValueChange = { noHp = it },
            label = { Text("NoHP") },
            placeholder = { Text("Masukan NoHP Anda") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat") },
            placeholder = { Text("Masukan Alamat Anda") }
        )



        Button(
            onClick = {
                onClickButton(wrapData)
            },
            modifier = Modifier.padding(vertical = 20.dp)
        ) {
            Text("SUBMIT")

        }

    }

}



