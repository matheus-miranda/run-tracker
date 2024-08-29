@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.msmlabs.run.presentation.active_run

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msmlabs.core.presentation.designsystem.RunTrackerTheme
import com.msmlabs.core.presentation.designsystem.StartIcon
import com.msmlabs.core.presentation.designsystem.StopIcon
import com.msmlabs.core.presentation.designsystem.components.RuntrackerFloatingActionButton
import com.msmlabs.core.presentation.designsystem.components.RuntrackerScaffold
import com.msmlabs.core.presentation.designsystem.components.RuntrackerToolbar
import com.msmlabs.run.presentation.R
import com.msmlabs.run.presentation.active_run.components.RunDataCard
import org.koin.androidx.compose.koinViewModel

@Composable
fun ActiveRunScreenRoot(
    viewModel: ActiveRunViewModel = koinViewModel(),
) {
    ActiveRunScreen(
        state = viewModel.state,
        onAction = viewModel::onAction,
    )
}

@Composable
private fun ActiveRunScreen(
    state: ActiveRunState,
    onAction: (ActiveRunAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    RuntrackerScaffold(
        withGradient = false,
        topAppBar = {
            RuntrackerToolbar(
                showBackButton = true,
                title = stringResource(id = R.string.active_run),
                onBackClick = {
                    onAction(ActiveRunAction.OnBackClick)
                }
            )
        },
        floatingActionButton = {
            RuntrackerFloatingActionButton(
                icon = if (state.shouldTrack) StopIcon else StartIcon,
                iconSize = 20.dp,
                onClick = { onAction(ActiveRunAction.OnToggleRunClick) },
                contentDescription = if (state.shouldTrack) {
                    stringResource(id = R.string.pause_run)
                } else {
                    stringResource(id = R.string.start_run)
                }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                RunDataCard(
                    elapsedTime = state.elapsedTime, runData = state.runData,
                    modifier = Modifier
                        .padding(16.dp)
                        .padding(paddingValues)
                        .fillMaxWidth()
                )
            }
        }
    )
}

@Preview
@Composable
private fun ActiveRunScreenPreview() {
    RunTrackerTheme {
        ActiveRunScreen(
            state = ActiveRunState(),
            onAction = {}
        )
    }
}

