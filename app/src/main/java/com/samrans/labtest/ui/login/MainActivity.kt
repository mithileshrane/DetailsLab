package com.samrans.labtest.ui.login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.samrans.labtest.R
import com.samrans.labtest.ui.base.BaseActivity
import java.time.format.DateTimeFormatter

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(R.id.framContainer,LoginFragment(), LoginFragment::class.simpleName!!,false)
    }
}
