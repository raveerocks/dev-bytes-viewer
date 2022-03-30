package io.raveerocks.devbytesviewer.domain

class VideoClick(val block: (Video) -> Unit) {
    fun onClick(video: Video) = block(video)
}