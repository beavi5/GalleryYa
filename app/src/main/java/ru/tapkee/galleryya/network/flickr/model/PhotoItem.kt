package ru.tapkee.galleryya.network.flickr.model

import com.google.gson.annotations.SerializedName

data class PhotoItem(

	@field:SerializedName("owner")
	val owner: String? = null,

	@field:SerializedName("server")
	val server: String? = null,

	@field:SerializedName("url_t")
	val urlT: String? = null,

	@field:SerializedName("height_t")
	val heightT: String? = null,

	@field:SerializedName("isfriend")
	val isfriend: Int? = null,

	@field:SerializedName("secret")
	val secret: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("height_m")
	val heightM: String? = null,

	@field:SerializedName("isfamily")
	val isfamily: Int? = null,

	@field:SerializedName("height_o")
	val heightO: String? = null,

	@field:SerializedName("width_t")
	val widthT: String? = null,

	@field:SerializedName("ispublic")
	val ispublic: Int? = null,

	@field:SerializedName("farm")
	val farm: Int? = null,

	@field:SerializedName("url_o")
	val urlO: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("url_m")
	val urlM: String? = null,

	@field:SerializedName("width_m")
	val widthM: String? = null,

	@field:SerializedName("width_o")
	val widthO: String? = null
)