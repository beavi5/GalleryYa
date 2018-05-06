package ru.tapkee.galleryya.network.flickr.model

import com.google.gson.annotations.SerializedName

data class PhotosResponse(

	@field:SerializedName("stat")
	val stat: String? = null,

	@field:SerializedName("photos")
	val photos: Photos? = null
)