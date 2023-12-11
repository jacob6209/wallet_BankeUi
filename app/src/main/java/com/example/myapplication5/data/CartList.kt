package com.example.myapplication5.data

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector

data class CartList(
    val Cart_Type:String,
    val Cart_Number:String,
    val Cart_Name:String,
    val balance:Float,
    val color:Brush
)
