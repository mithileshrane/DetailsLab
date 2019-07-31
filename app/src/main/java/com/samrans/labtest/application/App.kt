package com.samrans.labtest.application

import android.app.Application
import android.content.Context

class App:Application() {



    override fun onCreate() {
        super.onCreate()
        mContext = this
    }

    companion object{
        private var mContext: App?=null

        fun getApplicationContext():Context{
          return mContext?.applicationContext!!
        }
    }


}