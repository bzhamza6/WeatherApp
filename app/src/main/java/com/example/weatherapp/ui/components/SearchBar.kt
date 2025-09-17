package com.example.weatherapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.*

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
){
    var searchQuery by remember{ mutableStateOf("") }
    OutlinedTextField(
        value = searchQuery,
        onValueChange = {
            searchQuery = it
        },
        placeholder = {
        },
        leadingIcon = { Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null
        )},
        trailingIcon = {
            if(searchQuery.isNotEmpty()){
                IconButton(
                    onClick = {

                    }
                ){
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null
                    )
                }
            }
        },
        modifier = modifier
    )
}

@Composable
@Preview
fun SearchBarPreview(){
    SearchBar(

    )
}