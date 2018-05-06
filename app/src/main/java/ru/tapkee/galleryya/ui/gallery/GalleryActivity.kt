package ru.tapkee.galleryya.ui.gallery

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_gallary.*
import ru.tapkee.gallaryya.R
import ru.tapkee.galleryya.network.flickr.FlickrClient
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import ru.tapkee.galleryya.ui.base.BaseActivity
import io.reactivex.disposables.CompositeDisposable

/*Основной экран для отображения ленты картинок*/
class GalleryActivity : BaseActivity() {
    private val compositeDisposable = CompositeDisposable()
    private val layoutManager = GridLayoutManager(this, 3)
    private var page = 1
    private var isLoading = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallary)

        initRecyclerView()
        loadMorePhotos()
    }

    private fun initRecyclerView() {
        rvGallary.layoutManager = layoutManager
        rvGallary.adapter = RVadapter()
        rvGallary.addOnScrollListener(recyclerViewOnScrollListener)
    }


    //Пагинация
    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val visibleItemCount = layoutManager.getChildCount()
            val totalItemCount = layoutManager.getItemCount()
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

            if (!isLoading) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= PAGE_SIZE) loadMorePhotos()
            }
        }
    }

    private fun loadMorePhotos() {
        isLoading = true
        showProgress()
        compositeDisposable.add(FlickrClient.getService().getPhotos(page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    isLoading = false
                    page++
                    hideProgress()
                    (rvGallary.adapter as RVadapter).addNewPhotos(it.photos?.photo
                            ?: return@subscribe)
                })
    }

    override fun showProgress() {
        pb_gallery.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        pb_gallery.visibility = View.INVISIBLE
    }

    override fun showError(errorMsg: String) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

}
