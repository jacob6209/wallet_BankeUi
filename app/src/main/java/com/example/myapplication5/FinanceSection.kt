package com.example.myapplication5

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication5.data.Finance
import com.example.myapplication5.ui.theme.BlueStart
import com.example.myapplication5.ui.theme.GreenStart
import com.example.myapplication5.ui.theme.OrangeStart
import com.example.myapplication5.ui.theme.PurpleStart

val financeList = listOf<Finance>(
    Finance(
        icon = Icons.Rounded.Star,
        name = "My\n Business",
        background = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.Person,
        name = "My\nWallet",
        background = BlueStart

    ),
    Finance(
        icon = Icons.Rounded.Star,
        name = "Finance\nAnalytic",
        background = PurpleStart
    ),
    Finance(
        icon = Icons.Rounded.ThumbUp,
        name = "My\nTransactions",
        background = GreenStart
    )

)

@Preview
@Composable
fun FinanceSection() {
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow {
            items(financeList.size) { index ->
                financeItem(index)
            }
        }

    }

}

@Composable
fun financeItem(index: Int) {
    val financeCard = financeList[index]
    var lastPading = 0.dp
    if (index == financeList.size - 1) {
        lastPading = 16.dp
    }
    Box(Modifier.padding(start = 16.dp, end = lastPading)) {
    Column(modifier = Modifier
        .clip(RoundedCornerShape(25.dp))
        .background(MaterialTheme.colorScheme.secondaryContainer)
        .clickable { }
        .size(120.dp)
        .padding(13.dp),
        verticalArrangement = Arrangement.SpaceBetween)
    {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(financeCard.background)
                .padding(6.dp)
        ) {
            Icon(
                imageVector = financeCard.icon,
                contentDescription = financeCard.name,
                tint = Color.White
            )
        }

        Text(
            text = financeCard.name,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )
    }
}

}
