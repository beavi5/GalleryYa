package ru.tapkee.galleryya.network.flickr

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import ru.tapkee.galleryya.network.flickr.model.PhotosResponse
import java.util.*

//Интерфейс rest сервиса flickr для retrofit'а
interface FlickrService {

    @GET("?method=flickr.photos.getRecent&api_key=be00e7f9fb70df90a8037ed1e3ea2e66&per_page=15&format=json&nojsoncallback=1&extras=url_m,url_t,url_o")
    fun getPhotos(//@Query("api_key") apiKey: String,
                     @Query("page") currentPage: Int
    ): Observable<PhotosResponse>
}