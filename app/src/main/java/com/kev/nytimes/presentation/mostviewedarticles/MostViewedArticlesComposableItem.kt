package com.kev.nytimes.presentation.mostviewedarticles

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kev.nytimes.domain.model.mostviewedarticles.MostViewedResult
import com.kev.nytimes.ui.theme.RobotoBold
import com.kev.nytimes.ui.theme.RobotoLight
import com.kev.nytimes.ui.theme.RobotoRegular
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MostViewedArticlesComposableItem(
    result: MostViewedResult
) {
    Card(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(all = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxSize()
        ) {
            Column {
                Text(text = result.section, fontFamily = RobotoLight)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = result.title, fontFamily = RobotoBold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = result.byline, fontFamily = RobotoRegular)
              //  val lastUpdate = convertTimeStamp(result.updated)

              //  Text(text = "Updated at ".plus(lastUpdate))
            }
        }
//
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun convertTimeStamp(timeStamp: String): String {
    val inputFormat = DateTimeFormatter.ISO_LOCAL_DATE
    val outputFormat = DateTimeFormatter.ofPattern("MMMM d',' yyyy", Locale.ENGLISH)
    val dateTime = LocalDateTime.parse(timeStamp, inputFormat)
    return outputFormat.format(dateTime)
}
