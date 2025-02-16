package com.example.myfirstkotlinapplication.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myfirstkotlinapplication.DataManager
import com.example.myfirstkotlinapplication.Product
import com.example.myfirstkotlinapplication.R
import com.example.myfirstkotlinapplication.ui.theme.Alternative1
import com.example.myfirstkotlinapplication.ui.theme.Alternative2
import com.example.myfirstkotlinapplication.ui.theme.Primary

@Composable
fun MenuPage(dataManager: DataManager,modifier: Modifier = Modifier) {
   LazyColumn(){
       items(dataManager.menu){
           Text(it.name,
               color = Primary,
               modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 10.dp)
               )
           it.products.forEach{
               Card(
                   shape = RoundedCornerShape(16.dp),
                   modifier = Modifier
                       .background(Alternative2)
                       .padding(12.dp)
               ) {
                   ProductItem(product = it, onAdd = {})
               }
           }
       }

   }
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)

@Composable
fun ProductItem(product: Product, onAdd: (Product)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        Image(
            painter = painterResource(id = R.drawable.black_coffee),
            contentDescription = "Image for ${product.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(product.name, fontWeight = FontWeight.Bold)
                Text("$${product.price.format(2)} ea")
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    Alternative1,
                    Color.White
                ),
                onClick = {
                    onAdd(product)
                },
            ) {
                Text("Add")
            }
        }
    }
}