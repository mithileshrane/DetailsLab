package com.samrans.labtest.ui.login

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.samrans.labtest.R
import com.samrans.labtest.utils.Status

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    val validateLoginLiveData=MutableLiveData<Boolean>()


    fun logincall(userName:String,password:String){

    }

    public fun validateLogin(edt_username: String, edt_password: String) {
        when{
            edt_username.isEmpty()->{
//                Toast.makeText(activity!!, R.string.txt_invalid_username, Toast.LENGTH_SHORT).show()
                return validateLoginLiveData.setValue(false)
            }

            edt_password.isEmpty()->{
//                Toast.makeText(activity!!, R.string.txt_invalid_password, Toast.LENGTH_SHORT).show()
//                return false
                return validateLoginLiveData.setValue(false)
            }

            edt_password.length<5->{
//                Toast.makeText(activity!!, R.string.txt_invalid_password_length, Toast.LENGTH_SHORT).show()
//                return false
                return validateLoginLiveData.setValue(false)
            }
            else->{
//                return true

                return validateLoginLiveData.setValue(true)            }
        }
    }

}