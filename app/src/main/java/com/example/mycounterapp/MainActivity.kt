package com.example.mycounterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycounterapp.ui.theme.MyCounterAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel:CountViewModel=viewModel()
            MyCounterAPPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TheCounterAPP(
                        modifier = Modifier.padding(innerPadding),viewModel
                    )
                }
            }
        }
    }
}
@Composable
fun TheCounterAPP(modifier: Modifier,viewModel: CountViewModel){
    val count= remember { mutableStateOf(0) }
    val name= remember { mutableStateOf("") }



    Column(modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

        ) { Text(text = "${viewModel.count.value}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold)

        Spacer(modifier=Modifier.height(16.dp))
        Row {
            Button(onClick = {viewModel.increment()}) {
                Text("Increment")
            }
        }
        Spacer(modifier=Modifier.height(16.dp))
        Row {
            Button(onClick = {viewModel.decrement()}) {
                Text("decrement")
            }


        }


    }
}
