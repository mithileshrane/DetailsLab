package com.samrans.labtest.application

import android.app.Application
import android.content.Context
import com.samrans.labtest.apicalling.ApiClient
import com.samrans.labtest.database.AppDatabase
import com.samrans.labtest.ui.login.LoginRepository
import com.samrans.labtest.ui.login.LoginViewModelFactory
import com.samrans.labtest.utils.NetworkConnectionInterceptor
import com.samrans.labtest.utils.PreferenceProvider
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class App:Application() , KodeinAware {

    override val kodein = Kodein.lazy {
        /* bindings */
        import(androidXModule(this@App))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from provider { LoginViewModelFactory(instance()) }
        bind() from provider { LoginRepository(instance(),instance(),instance()) }
        bind() from singleton { ApiClient(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
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