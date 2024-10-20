@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package com.msmlabs.run.presentation.run_overview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msmlabs.core.presentation.designsystem.AnalyticsIcon
import com.msmlabs.core.presentation.designsystem.LogoIcon
import com.msmlabs.core.presentation.designsystem.LogoutIcon
import com.msmlabs.core.presentation.designsystem.RunIcon
import com.msmlabs.core.presentation.designsystem.RunTrackerTheme
import com.msmlabs.core.presentation.designsystem.components.RuntrackerFloatingActionButton
import com.msmlabs.core.presentation.designsystem.components.RuntrackerScaffold
import com.msmlabs.core.presentation.designsystem.components.RuntrackerToolbar
import com.msmlabs.core.presentation.designsystem.components.util.DropDownItem
import com.msmlabs.run.presentation.R
import com.msmlabs.run.presentation.run_overview.components.RunListItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun RunOverviewScreenRoot(
    onStartRunClick: () -> Unit,
    onLogoutClick: () -> Unit,
    viewModel: RunOverviewViewModel = koinViewModel(),
) {
    RunOverviewScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                RunOverviewAction.OnStartClick -> onStartRunClick.invoke()
                RunOverviewAction.OnLogoutClick -> onLogoutClick.invoke()
                else -> Unit
            }
            viewModel.onAction(action)
        },
    )
}

@Composable
private fun RunOverviewScreen(
    state: RunOverviewState,
    onAction: (RunOverviewAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )

    RuntrackerScaffold(
        topAppBar = {
            RuntrackerToolbar(
                showBackButton = false,
                title = stringResource(id = R.string.runtracker),
                scrollBehavior = scrollBehavior,
                startContent = {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                },
                menuItems = listOf(
                    DropDownItem(
                        icon = AnalyticsIcon,
                        title = stringResource(id = R.string.analytics)
                    ),
                    DropDownItem(
                        icon = LogoutIcon,
                        title = stringResource(id = R.string.logout)
                    )
                ),
                onMenuItemClick = { index ->
                    when (index) {
                        0 -> onAction.invoke(RunOverviewAction.OnAnalyticsClick)
                        1 -> onAction.invoke(RunOverviewAction.OnLogoutClick)
                    }

                }
            )
        },
        floatingActionButton = {
            RuntrackerFloatingActionButton(icon = RunIcon, onClick = { onAction(RunOverviewAction.OnStartClick) })
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection)
                    .padding(horizontal = 16.dp),
                contentPadding = paddingValues,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(
                    items = state.runs,
                    key = { it.id }
                ) {
                    RunListItem(
                        runUi = it,
                        onDeleteClick = { onAction.invoke(RunOverviewAction.DeleteRun(it)) },
                        modifier = Modifier.animateItemPlacement()
                    )
                }
            }

        }
    )
}

@Preview
@Composable
private fun RunOverviewScreenPreview() {
    RunTrackerTheme {
        RunOverviewScreen(
            state = RunOverviewState(),
            onAction = {}
        )
    }
}
