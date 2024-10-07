package com.example.calc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Composable
fun calcmain(modifier: Modifier = Modifier){

    var display by remember { mutableStateOf("0") }
    var calcNum by remember { mutableStateOf<Int?>(null)}
    val buttons = listOf(
        listOf("AC","Â±","%","/"),
        listOf("7","8","9","X"),
        listOf("4","5","6","-"),
        listOf("7","8","9","+"),
        listOf("","0",",","=",)
    )

    fun getLabelNum(number : Int){

        display = if (display == "0") {
            number.toString()
        } else {
            display + number.toString()
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = display, modifier = Modifier.padding(64.dp).fillMaxWidth(), fontSize = 64.sp)

        buttons.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                row.forEach { label ->
                    Button(
                        onClick = {
                            val labelbutton = label.toIntOrNull()
                            if(labelbutton != null){
                                calcNum = getLabelNum(labelbutton);
                            }else{
                                when (label) {
                                    "+" -> {
                                        // Add your logic for "+"
                                        display = "0";
                                        calcNum + getLabelNum(labelbutton)
                                    }

                                    "-" -> {
                                        // Add your logic for "-"
                                    }

                                    "/" -> {
                                        // Add your logic for "/"
                                    }

                                    "X" -> {
                                        // Add your logic for "*"
                                    }

                                    else -> {
                                        // Handle any other unexpected input
                                        display = "Unknown input"
                                    }
                                }
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .padding(4.dp)
                            .height(64.dp)
                    ) {
                        Text(text = label, fontSize = 24.sp)
                    }

                }
            }
        }
    }
}

