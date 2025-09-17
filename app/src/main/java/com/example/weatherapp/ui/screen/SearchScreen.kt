package com.example.weatherapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.components.SearchBar

@Composable
fun SearchScreen(){
    Column {
        SearchBar(
            modifier = Modifier
                .padding(top = 20.dp,start = 8.dp,end=8.dp)
                .fillMaxWidth()
        )
    }
}