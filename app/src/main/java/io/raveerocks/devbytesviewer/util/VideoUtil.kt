package io.raveerocks.devbytesviewer.util

import android.net.Uri
import io.raveerocks.devbytesviewer.db.DatabaseVideoEntity
import io.raveerocks.devbytesviewer.domain.Video
import io.raveerocks.devbytesviewer.network.NetworkVideoContainer

fun List<DatabaseVideoEntity>.asDomainModel(): List<Video> {
    return map {
        Video(
            url = it.url,
            title = it.title,
            description = it.description,
            updated = it.updated,
            thumbnail = it.thumbnail
        )
    }
}

fun NetworkVideoContainer.asDatabaseModel(): Array<DatabaseVideoEntity> {
    return videos.map {
        DatabaseVideoEntity(
            title = it.title,
            description = it.description,
            url = it.url,
            updated = it.updated,
            thumbnail = it.thumbnail
        )
    }.toTypedArray()
}

fun Video.launchUri(): Uri {
    val httpUri = Uri.parse(url)
    return Uri.parse("vnd.youtube:" + httpUri.getQueryParameter("v"))
}