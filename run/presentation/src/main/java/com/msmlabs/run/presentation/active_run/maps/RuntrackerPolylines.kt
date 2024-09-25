package com.msmlabs.run.presentation.active_run.maps

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.JointType
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Polyline
import com.msmlabs.core.domain.location.LocationTimestamp

@Composable
fun RuntrackerPolylines(
    locations: List<List<LocationTimestamp>>,
) {
    val polylines = remember(locations) {
        locations.map {
            it.zipWithNext { timestamp1, timestamp2 ->
                PolylineUI(
                    location1 = timestamp1.location.location,
                    location2 = timestamp2.location.location,
                    color = PolylineColorCalculator.locationToColor(
                        location1 = timestamp1,
                        location2 = timestamp2
                    )
                )
            }
        }
    }

    polylines.forEach { polyline ->
        polyline.forEach { polylineUI ->
            Polyline(
                points = listOf(
                    LatLng(polylineUI.location1.lat, polylineUI.location1.long),
                    LatLng(polylineUI.location2.lat, polylineUI.location2.long),
                ),
                color = polylineUI.color,
                jointType = JointType.BEVEL
            )
        }
    }
}
