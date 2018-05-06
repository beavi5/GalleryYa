package ru.tapkee.galleryya.ui.base

import android.support.v7.app.AppCompatActivity

//Базовое активити с основными общими функциями, которое должны наследовать все активити
abstract class BaseActivity : AppCompatActivity(), BaseActivityInt {
    abstract override fun showProgress()
    abstract override fun hideProgress()
    abstract override fun showError(errorMsg: String)
}