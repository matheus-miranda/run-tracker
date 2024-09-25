package com.msmlabs.run.location

import android.location.Location
import com.msmlabs.core.domain.location.LocationWithAltitude

fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        location = com.msmlabs.core.domain.location.Location(
            lat = latitude,
            long = longitude,
        ),
        altitude = altitude
    )
}
