package com.elishaazaria.sayboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import com.elishaazaria.sayboard.R
import com.mikepenz.aboutlibraries.ui.compose.LibrariesContainer

@Composable
public fun GrantPermissionUi(
    mic: State<Boolean>,
    ime: State<Boolean>,
    requestMic: () -> Unit,
    requestIme: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Button(onClick = requestMic, enabled = !mic.value) {
            if (mic.value) {
                Text(text = stringResource(id = R.string.mic_permission_granted))
            } else {
                Text(text = stringResource(id = R.string.mic_permission_not_granted))
            }
        }
        Button(onClick = requestIme, enabled = !ime.value) {
            if (ime.value) {
                Text(text = stringResource(id = R.string.keyboard_enabled))
            } else {
                Text(text = stringResource(id = R.string.keyboard_not_enabled))
            }
        }

        var showLibrariesPopup by remember { mutableStateOf(false) }
        Button(onClick = {
            showLibrariesPopup = true
        }) {
            Text(stringResource(id = R.string.show_libraries))
        }
        if (showLibrariesPopup) {
            Dialog(onDismissRequest = {
                showLibrariesPopup = false
            }) {
                LibrariesContainer(
                    Modifier.fillMaxSize()
                )
            }
        }
    }
}