package com.example.myapplication5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication5.data.CartList
import com.example.myapplication5.ui.theme.BlueEnd
import com.example.myapplication5.ui.theme.BlueStart
import com.example.myapplication5.ui.theme.GreenEnd
import com.example.myapplication5.ui.theme.GreenStart
import com.example.myapplication5.ui.theme.OrangeEnd
import com.example.myapplication5.ui.theme.OrangeStart
import com.example.myapplication5.ui.theme.PurpleEnd
import com.example.myapplication5.ui.theme.PurpleStart

val CartListItem = listOf<CartList>(
    CartList(
        Cart_Type = "VISA",
        Cart_Name = "Saving",
        balance = 46.467f,
        Cart_Number = "2356 0293 8340 2458",
        color = getGradiant(PurpleStart, PurpleEnd),
    ),
    CartList(
        Cart_Type = "MASTER CARD",
        Cart_Name = "Business",
        balance = 57.467f,
        Cart_Number = "2356 0293 8340 1458",
        color = getGradiant(BlueStart, BlueEnd),
    ),
    CartList(
        Cart_Type = "VISA",
        Cart_Name = "School",
        balance = 12.467f,
        Cart_Number = "2356 0293 8340 2138",
        color = getGradiant(GreenStart, GreenEnd),
    ),
    CartList(
        Cart_Type = "MASTER CARD",
        Cart_Name = "Trips",
        balance = 26.467f,
        Cart_Number = "2356 0293 8340 8488",
        color = getGradiant(OrangeStart, OrangeEnd),
    )


)


fun getGradiant(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}

@Preview
@Composable
fun CartSection() {
    LazyRow {
        items(CartListItem.size) { index ->
            CartItem(index)
        }
    }

}

@Composable
fun CartItem(index: Int) {
    val card = CartListItem[index]
    var lastItemPaddingEnd = 0.dp
    if (index == CartListItem.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    var img = painterResource(id = R.drawable.visa)
    if (card.Cart_Type == "MASTER CARD") {
        img = painterResource(id = R.drawable.master)
    }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
            .clip(RoundedCornerShape(25.dp))
            .background(card.color)
            .width(250.dp)
            .height(160.dp)
            .clickable {  }
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 16.dp)
                .clickable { }, verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = img,
                contentDescription = card.Cart_Name,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.Cart_Name,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.Cart_Number,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }

}
