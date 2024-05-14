package com.kanzankazu.composecleanarchitecture.presentation.screen.listuser

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kanzankazu.composecleanarchitecture.presentation.R
import com.kanzankazu.composecleanarchitecture.presentation.component.TitleTopBar
import com.kanzankazu.composecleanarchitecture.presentation.util.initMod
import kotlinx.coroutines.delay

@Composable
fun ListUserScreen(viewModel: ListUserViewModel = hiltViewModel()) {

    var searchText by rememberSaveable { mutableStateOf("") }
    val searchUserResultState = viewModel.usersList.collectAsState()

    LaunchedEffect(key1 = searchText) {
        //if (searchText.isBlank()) return@LaunchedEffect
        delay(1000)
        viewModel.getUsers(searchText)
    }

    Scaffold(
        topBar = { TitleTopBar(title = "Github Users") }
    ) {
        Column(
            modifier = initMod()
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = initMod()
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
            ) {
                OutlinedTextField(
                    modifier = initMod()
                        .fillMaxWidth(),
                    value = searchText,
                    label = { Text(text = stringResource(id = R.string.label_search)) },
                    keyboardActions = KeyboardActions(),
                    onValueChange = { searchText = it }
                )

                ListUserContainer(searchUserResultState)
            }
        }
    }
}