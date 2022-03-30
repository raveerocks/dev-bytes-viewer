package io.raveerocks.devbytesviewer.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import io.raveerocks.devbytesviewer.db.VideosDatabase
import io.raveerocks.devbytesviewer.db.VideosRepository
import io.raveerocks.devbytesviewer.domain.Video
import kotlinx.coroutines.launch

class DevByteViewModel(application: Application) : AndroidViewModel(application) {

    private val database = VideosDatabase.getDatabase(application)
    private val videosRepository = VideosRepository(database)
    val playlist: LiveData<List<Video>> = videosRepository.videos

    init {
        viewModelScope.launch {
            videosRepository.refreshVideos()
        }
    }

}