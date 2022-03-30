package io.raveerocks.devbytesviewer.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import io.raveerocks.devbytesviewer.domain.Video
import io.raveerocks.devbytesviewer.network.DevByteService
import io.raveerocks.devbytesviewer.util.asDatabaseModel
import io.raveerocks.devbytesviewer.util.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class VideosRepository(private val database: VideosDatabase) {

    private var devByteService: DevByteService = DevByteService.getDevByteService()

    val videos: LiveData<List<Video>> = Transformations.map(database.videoDao.getVideos()) {
        it.asDomainModel()
    }

    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = devByteService.getPlaylist().await()
            database.videoDao.insertAll(*playlist.asDatabaseModel())
        }
    }

}