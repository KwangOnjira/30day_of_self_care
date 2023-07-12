package com.example.daysofselfcare

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.daysofselfcare.model.SelfCare
import com.example.daysofselfcare.ui.theme.DaysOfSelfCareTheme

@Composable
fun DayCard(selfCare: SelfCare,modifier: Modifier = Modifier){
    var expanded by remember { mutableStateOf(false) }
    Card(shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { expanded = !expanded }) {
        Row() {
            NumDaysTitle(day = selfCare.day, title = selfCare.title)
        }
        AnimatedVisibility(visible = expanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()) {
            NumDaysDetail(title = selfCare.title, image = selfCare.image,
                description1 = selfCare.description1, description2 = selfCare.description2)
        }

    }
}

@Composable
fun NumDaysTitle(@StringRes day: Int,
            @StringRes title: Int,
            modifier: Modifier = Modifier){
    Column(modifier = modifier
        .padding(16.dp)
        .fillMaxWidth(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = day),
        style = MaterialTheme.typography.displayMedium)

        Text(text = stringResource(id = title),
        style = MaterialTheme.typography.titleMedium,
        textAlign = TextAlign.Center)

    }
}

@Composable
fun NumDaysDetail(@StringRes title: Int,
                  @DrawableRes image: Int,
                  @StringRes description1: Int,
                  @StringRes description2: Int,
                 modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(20.dp)) {

        Image(painter = painterResource(id = image),
            contentDescription = stringResource(id = title),
            modifier = Modifier
                .aspectRatio(16f / 9f)
                .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop,)

        Spacer(modifier.size(20.dp))

        Text(text = stringResource(id = description1),
        style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier.size(18.dp))

        Text(text = stringResource(id = description2),
            style = MaterialTheme.typography.bodyLarge)
    }
}


@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DayCardPreview(){
    DaysOfSelfCareTheme{
        val day = SelfCare(R.string.Day1,R.string.title1,R.drawable.d1,R.string.des_D1,R.string.des2_D1)
        
        DayCard(selfCare = day)
    }
}