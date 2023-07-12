package com.example.daysofselfcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.daysofselfcare.data.Data30Days
import com.example.daysofselfcare.ui.theme.DaysOfSelfCareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaysOfSelfCareTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.secondaryContainer
                ) {
                    SelfCareApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelfCareApp(modifier: Modifier = Modifier){
    Scaffold(modifier = modifier.fillMaxSize(),
    topBar = { TopBarApp() }) {it -> LazyColumn(contentPadding = it){
        items(Data30Days.Days){
            DayCard(selfCare = it,modifier = Modifier.padding(8.dp))
        }
    }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarApp(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.self_care),
                    contentDescription = "Icon",
                modifier = modifier.size(64.dp)
                    .padding(8.dp))

                Text(
                    text = stringResource(id = R.string.title),
                    style = MaterialTheme.typography.headlineMedium
                )
            }

        },
    )
}

@Preview
@Composable
fun HeroAppPreview() {
    DaysOfSelfCareTheme {
        SelfCareApp(modifier = Modifier.padding(16.dp))
    }
}