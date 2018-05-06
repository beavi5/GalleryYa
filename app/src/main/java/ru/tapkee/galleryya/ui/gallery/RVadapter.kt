package ru.tapkee.galleryya.ui.gallery

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rv_photo_preview_row.view.*
import ru.tapkee.gallaryya.R
import ru.tapkee.galleryya.network.flickr.model.PhotoItem
import ru.tapkee.galleryya.ui.photo.PhotoActivity
import java.util.*

class RVadapter(var photos: MutableList<PhotoItem?> = ArrayList()): RecyclerView.Adapter<RVadapter.PhotoHolder>() {

    fun addNewPhotos(photos: List<PhotoItem?>){
        this.photos.addAll(photos)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder =
            PhotoHolder(  LayoutInflater.from(parent.context).inflate(R.layout.rv_photo_preview_row, parent, false))


    override fun getItemCount()= photos.size


    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
    holder.bind(photos[position])
    }


    inner class PhotoHolder(v: View): RecyclerView.ViewHolder(v){

        fun bind(photoUrl: PhotoItem?){

            photoUrl?.urlT?.let {Picasso.get().load(it).into(itemView.iv_PhotoPreview)
            }

            photoUrl?.urlO?.let {
                itemView.setOnClickListener {
                 val intent =  Intent(it.context, PhotoActivity::class.java).apply { putExtra("photoUrl",photoUrl?.urlO)}
                    it.context.startActivity(intent)
                }
            }
        }
    }
}