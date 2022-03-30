package io.raveerocks.devbytesviewer.view

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DevByteViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DevByteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DevByteViewModel(app) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}