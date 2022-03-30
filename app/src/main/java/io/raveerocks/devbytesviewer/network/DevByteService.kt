package io.raveerocks.devbytesviewer.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface DevByteService {

    companion object {

        private lateinit var INSTANCE: DevByteService

        fun getDevByteService(): DevByteService {
            synchronized(DevByteService::class.java) {
                if (!::INSTANCE.isInitialized) {
                    val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://devbytes.udacity.com/")
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
                        .addCallAdapterFactory(CoroutineCallAdapterFactory())
                        .build()
                    INSTANCE = retrofit.create(DevByteService::class.java)
                }
            }
            return INSTANCE
        }
    }

    @GET("devbytes.json")
    fun getPlaylist(): Deferred<NetworkVideoContainer>

}