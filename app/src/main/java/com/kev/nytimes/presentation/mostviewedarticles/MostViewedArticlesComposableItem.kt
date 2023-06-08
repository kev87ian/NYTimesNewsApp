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
import com.kev.nytimes.presentation.toparticles.convertTime
import com.kev.nytimes.ui.theme.RobotoBold
import com.kev.nytimes.ui.theme.RobotoLight
import com.kev.nytimes.ui.theme.RobotoRegular
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MostViewedArticlesComposableItem(
    result: MostViewedResult
){

    Card(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(all = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxSize()
        ) {
            Column {
                result.section?.let { Text(text = it, fontFamily = RobotoLight) }
                Spacer(modifier = Modifier.height(8.dp))
                result.title?.let { Text(text = it, fontFamily = RobotoBold) }
                Spacer(modifier = Modifier.height(8.dp))
                result.byline?.let { Text(text = it, fontFamily = RobotoRegular) }
                val lastUpdate = result.updated.let { convertTime(it) }


                Text(text = "Updated ".plus(lastUpdate))
            }
        }
//
    }

}

@RequiresApi(Build.VERSION_CODES.O)
fun convertTime(timeStamp: String): String {
    val formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH)
    val dateTime = OffsetDateTime.parse(timeStamp)

    return dateTime.format(formatter)
}
