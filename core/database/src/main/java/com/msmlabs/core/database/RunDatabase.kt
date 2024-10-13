package com.msmlabs.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.msmlabs.core.database.dao.RunDao
import com.msmlabs.core.database.dao.RunPendingSyncDao
import com.msmlabs.core.database.entity.DeletedRunSyncEntity
import com.msmlabs.core.database.entity.RunEntity
import com.msmlabs.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [RunEntity::class, RunPendingSyncEntity::class, DeletedRunSyncEntity::class],
    version = 1,
)
abstract class RunDatabase : RoomDatabase() {
    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
}
