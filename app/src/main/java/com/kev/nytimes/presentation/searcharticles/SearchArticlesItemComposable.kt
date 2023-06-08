package com.kev.nytimes.presentation.searcharticles

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
import com.kev.nytimes.domain.model.searcharticles.Doc
import com.kev.nytimes.ui.theme.RobotoBold
import com.kev.nytimes.ui.theme.RobotoLight
import com.kev.nytimes.ui.theme.RobotoRegular
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchArticlesItemComposable(
    result: Doc
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
                Text(text = result.sectionName, fontFamily = RobotoLight)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = result.abstract, fontFamily = RobotoBold)
                Spacer(modifier = Modifier.height(8.dp))
                result.byline.original?.let {
                    Text(text = it, fontFamily = RobotoRegular)
                }

                Text(text = "Published on: ".plus(convertDate(result.pubDate)))
                /*result.section?.let { Text(text = it, fontFamily = RobotoLight) }
                Spacer(modifier = Modifier.height(8.dp))
                result.title?.let { Text(text = it, fontFamily = RobotoBold) }
                Spacer(modifier = Modifier.height(8.dp))
                result.byline?.let { Text(text = it, fontFamily = RobotoRegular) }
                val lastUpdate = result.updatedDate?.let { convertTime(it) }
                Text(text = "Updated ".plus(lastUpdate))*/
            }
        }
//
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun convertDate(timeStamp: String): String {
    val inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")
    val outputFormat = DateTimeFormatter.ofPattern("dd/MM/yy")
    val dateTime = LocalDateTime.parse(timeStamp, inputFormat)
    return outputFormat.format(dateTime)
}
