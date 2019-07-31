package com.samrans.labtest.ui.listeners

/**
 * Simple Interfaces Listener  for callback of API call
 * true and false
 */
interface BasicAPICallBackListener {
    fun onSuccess(msg: String?)
    fun onFailure(t: Throwable?)
    fun onAlert(msg: String?)
}