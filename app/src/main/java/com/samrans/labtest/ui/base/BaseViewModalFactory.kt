package com.samrans.labtest.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.samrans.labtest.ui.login.LoginViewModel

class BaseViewModalFactory(private val repository: DataRepository): ViewModelProvider.NewInstanceFactory(){

   /* override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java!!)) {
            LoginViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }*/
}