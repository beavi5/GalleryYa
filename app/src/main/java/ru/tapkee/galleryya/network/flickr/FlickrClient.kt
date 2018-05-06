package ru.tapkee.galleryya.network.flickr

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


//Синглтон предоставляющий экземпляр rest сервиса для  работы с Flickr
object FlickrClient {
    val FlickrService = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/services/rest/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ru.tapkee.galleryya.network.flickr.FlickrService::class.java)

    fun getService(): FlickrService {
 return FlickrService
    }
}