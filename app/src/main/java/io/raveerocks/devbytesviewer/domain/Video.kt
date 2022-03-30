package io.raveerocks.devbytesviewer.domain

import io.raveerocks.devbytesviewer.util.smartTruncate

data class Video(
    val title: String,
    val description: String,
    val url: String,
    val updated: String,
    val thumbnail: String
) {

    val shortDescription: String
        get() = description.smartTruncate(200)
}