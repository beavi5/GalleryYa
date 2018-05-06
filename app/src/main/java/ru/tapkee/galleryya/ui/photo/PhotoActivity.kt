package ru.tapkee.galleryya.ui.photo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_photo.*
import ru.tapkee.gallaryya.R
import ru.tapkee.galleryya.ui.base.BaseActivity
import java.lang.Exception

class PhotoActivity : BaseActivity() {
    override fun showError(errorMsg: String) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
        pb_Photo.visibility = View.VISIBLE
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun hideProgress() {
        pb_Photo.visibility = View.INVISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_photo)
        intent.extras.getString("photoUrl")?.let {
            showProgress()
            Picasso.get().load(it).into(iv_Photo, object : Callback {
                override fun onError(e: Exception?) {
                    hideProgress()
                    showError(getString(R.string.load_img_error))
                }

                override fun onSuccess() {
                    hideProgress()
                }

            })

        }
    }
}
