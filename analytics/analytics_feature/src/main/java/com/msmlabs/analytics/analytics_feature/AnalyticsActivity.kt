package com.msmlabs.analytics.analytics_feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.play.core.splitcompat.SplitCompat
import com.msmlabs.analytics.data.di.analyticsModule
import com.msmlabs.analytics.presentation.AnalyticsDashboardScreenRoot
import com.msmlabs.analytics.presentation.di.analyticsPresentationModule
import com.msmlabs.core.presentation.designsystem.RunTrackerTheme
import org.koin.core.context.loadKoinModules

class AnalyticsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(
            listOf(analyticsModule, analyticsPresentationModule)
        )
        SplitCompat.installActivity(this)

        setContent {
            RunTrackerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "analytics_dashboard"
                ) {
                    composable("analytics_dashboard") {
                        AnalyticsDashboardScreenRoot(onBackClick = { finish() })
                    }
                }
            }
        }
    }
}
