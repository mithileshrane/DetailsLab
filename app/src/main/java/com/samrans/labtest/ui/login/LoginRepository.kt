package com.samrans.labtest.ui.login

import com.samrans.labtest.apicalling.ApiClient
import com.samrans.labtest.database.AppDatabase
import com.samrans.labtest.ui.base.DataRepository
import com.samrans.labtest.utils.PreferenceProvider

class LoginRepository(private val api: ApiClient,
                      private val db: AppDatabase,
                      private val pref: PreferenceProvider
){


}