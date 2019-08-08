package com.samrans.labtest.application

import android.app.Application
import android.content.Context
import com.samrans.labtest.utils.NetworkConnectionInterceptor
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class App:Application() , KodeinAware {

    override val kodein = Kodein.lazy {
        /* bindings */
        import(androidXModule(this@App))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }

    }

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