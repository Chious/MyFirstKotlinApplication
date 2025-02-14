package com.example.myfirstkotlinapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Offer(modifier: Modifier = Modifier) {

    val style = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp
    )

   Column(
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier.padding(16.dp)
   ){
       Text(text = "My Title",
           fontSize = 8.sp,
           style=MaterialTheme.typography.headlineLarge,
           modifier = Modifier.padding(2.dp)
           )
       Text(text ="Description",
            style= style
       )
   }
}