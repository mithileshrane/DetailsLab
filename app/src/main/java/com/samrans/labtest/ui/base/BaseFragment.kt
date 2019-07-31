package com.samrans.labtest.ui.base

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.samrans.labtest.application.App
import com.samrans.labtest.ui.listeners.OnUpdateView
import com.samrans.labtest.ui.login.LoginFragment
import java.time.format.DateTimeFormatter

abstract class BaseFragment : Fragment(), View.OnClickListener , OnUpdateView {

    val ARG_PARAM1 = "param1"
    val ARG_PARAM2 = "param2"
    val ARG_PARAM3 = "param3"

    open var mListener : OnFragmentInteractionListener ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments != null){

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return TextView(activity)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnFragmentInteractionListener) {
            mListener = context as OnFragmentInteractionListener
        }else{
            throw RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener")
        }
    }


    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun onClick(v: View) {

    }
    override fun updateView(position: Int) {
//       AppUtils.showLog("Base","updateView" + position)
    }
    public interface OnFragmentInteractionListener{

        fun addNewsFragment(@IdRes containerViewId : Int,
                            @NonNull fragment : Fragment,
                            @NonNull fragmentTag : String,
                            isAddToBackStack : Boolean)

        fun onFragmentInteraction(uri : Uri)

        fun onBackButtonPress()

        fun replaceFragment(@IdRes containerViewId : Int,
                            @NonNull fragment : Fragment,
                            @NonNull fragmentTag : String,
                            isAddToBackStack : Boolean)

        fun addFragment(@IdRes containerViewId : Int,
                        @NonNull fragment : Fragment,
                        @NonNull fragmentTag : String,
                        isAddToBackStack : Boolean)

        fun getToolbar() : Toolbar

        fun showToolbarBackBtn(isShown : Boolean)

        fun hideToolbar()

        fun showToolbar()

        fun setHomeIcon(drawable : Int)

        fun getAppInstantsContext():App

        fun toast(message: CharSequence, duration: Int)

        fun startActivity(intent: Intent)

        fun hideSoftKeyboard(view: View)

        fun hideSoftKeyboard()

        fun showSoftKeyboard(view: View)
        fun setToolbarTitle(title:Int)
        fun setToolbarElevation(flag:Float)
        fun setToolbarTitle(title:String)

//        fun showAlert(context: Context, message: String, title: String = "", listener: CustomAlertDialogListener? = null)

        fun showBottomNevigationBar()
        fun hideBottomNevigationBar()
        /**
         * BasicAPICallBackListener
         */
        fun onSuccess(msg: String?)
        fun onFailure(t: Throwable?)
        fun onAlert(msg: String?)
        fun checkVisibility(flag: Boolean): Int
    }
}