package com.msmlabs.run.domain

import com.msmlabs.core.domain.location.LocationWithAltitude
import kotlinx.coroutines.flow.Flow

interface LocationObserver {
    fun observeLocation(interval: Long): Flow<LocationWithAltitude>
}
