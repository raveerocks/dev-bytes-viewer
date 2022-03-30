package io.raveerocks.devbytesviewer.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DatabaseVideoEntity::class], version = 1, exportSchema = false)
abstract class VideosDatabase : RoomDatabase() {

    abstract val videoDao: VideoDao

    companion object {

        private lateinit var INSTANCE: VideosDatabase

        fun getDatabase(context: Context): VideosDatabase {
            synchronized(VideosDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        VideosDatabase::class.java,
                        "videos"
                    ).build()
                }
            }
            return INSTANCE
        }
    }

}