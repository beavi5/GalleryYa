package ru.tapkee.galleryya.ui.base


//Интерфейс с методами базового активити
interface BaseActivityInt {
    fun showProgress()
    fun hideProgress()
    fun showError(errorMsg: String)
}