package com.samrans.labtest.ui.base

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.InputFilter
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.samrans.labtest.R
import com.samrans.labtest.application.App
import com.samrans.labtest.ui.listeners.BasicAPICallBackListener
import java.time.format.DateTimeFormatter
import java.util.*

abstract class BaseActivity : AppCompatActivity(), BaseFragment.OnFragmentInteractionListener ,
    BasicAPICallBackListener {
    var CAMERA_REQUEST = 101
    var GALLERY_REQUEST = 102
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = ProgressDialog(this)
        progressDialog?.isIndeterminate = true
        progressDialog?.setCancelable(false)
    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onBackButtonPress() {
        finish()
    }

    override fun addNewsFragment(containerViewId: Int, fragment: Fragment, fragmentTag: String, isAddToBackStack: Boolean) {
        if (isAddToBackStack) {
            supportFragmentManager
                .beginTransaction()
                .add(containerViewId, fragment, fragmentTag)
                .setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE )
                .addToBackStack(fragmentTag).commitAllowingStateLoss()
        } else {
            supportFragmentManager
                .beginTransaction()
                .setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE )
                .add(containerViewId, fragment, fragmentTag)
                .commitAllowingStateLoss()
        }

    }

    override fun replaceFragment(containerViewId: Int, fragment: Fragment, fragmentTag: String, isAddToBackStack: Boolean) {

        if (isAddToBackStack) {
            supportFragmentManager
                .beginTransaction()
                .replace(containerViewId, fragment, fragmentTag)
                .setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE )
                .addToBackStack(fragmentTag).commitAllowingStateLoss()
        } else {
            supportFragmentManager
                .beginTransaction()
                .setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE )
                .replace(containerViewId, fragment, fragmentTag)
                .commitAllowingStateLoss()
        }


    }

    override fun addFragment(containerViewId: Int, fragment: Fragment, fragmentTag: String, isAddToBackStack: Boolean) {

        if (isAddToBackStack) {
            supportFragmentManager
                .beginTransaction()
                .replace(containerViewId, fragment, fragmentTag)
                .setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE )
                .addToBackStack(fragmentTag).commitAllowingStateLoss()
        } else {
            supportFragmentManager
                .beginTransaction()
                .replace(containerViewId, fragment, fragmentTag)
                .setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE )
                .commitAllowingStateLoss()
        }
    }

    override fun getToolbar(): Toolbar {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showToolbarBackBtn(isShown: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideToolbar() {
        supportActionBar?.hide() //To change body of created functions use File | Settings | File Templates.
    }

    override fun showToolbar() {
        supportActionBar?.show()
    }

    override fun setHomeIcon(drawable: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAppInstantsContext(): App {
        return applicationContext as App
    }

    override fun toast(message: CharSequence, duration: Int) {

        Toast.makeText(this, message, duration).show()
    }

    override fun finish() {
        //      //FollowUpApplication.currentActivityName=""
        super.finish()
        //overridePendingTransitionExit()
    }


    /*override fun onPostResume() {
        FollowUpApplication.currentActivityName ="com.tilishare.tilishare.${this.localClassName}"
        super.onPostResume()
    }*/


    override fun startActivity(intent: Intent) {
        super.startActivity(intent)
        //overridePendingTransitionEnter()
    }

    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    protected fun overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    protected fun overridePendingTransitionExit() {
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }

    /**
     * API onSuccess result
     * we can also manage network issue
     */
    override fun onSuccess(msg:String?) {

    }
    /**
     * API onFailure result
     * we can also manage network issue
     */
    override fun onFailure(t: Throwable?) {
//        when (t) {
//            // is HttpException -> resolution.onHttpException(throwable)
//            // let your location implementation throw a custom exception on timeout, for example
//            is NetworkConnectionInterceptor.NoConnectivityException -> AppUtils.showNoInternetDialog(this!!)
//            is NetworkConnectionInterceptor.InternetException -> AppUtils.showToast("No internet available.")
//            else -> AppUtils.showNoInternetDialog(this!!)
//            //else -> t?.apply { /*resolution.onGenericRxException(this)*/ }
//        }
    }
    /**
     * API error message
     * we can also manage network issue
     */
    override fun onAlert(msg: String?){
//        AppUtils.showAlertDialog(this, msg!!, getString(R.string.txt_error), null)
    }

    /**
     * Hides the soft keyboard
     */
    override fun hideSoftKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun hideSoftKeyboard() {
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    override fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    override fun setToolbarTitle(title: Int) {
        supportActionBar!!.setTitle(getString(title))
    }

    override fun setToolbarElevation(elevation: Float) {
        supportActionBar!!.elevation = elevation
    }

    override fun setToolbarTitle(title: String) {
        supportActionBar!!.setTitle(title)
    }



    /*override fun showAlert(context: Context, message: String, title: String*//*, listener: CustomAlertDialogListener?*//*) {
//        AppUtils.showAlertDialog(context, message, title, listener)
    }*/

    override fun showBottomNevigationBar() {
//        navigation.visibility = View.VISIBLE
    }

    override fun hideBottomNevigationBar() {
//        navigation.visibility = View.GONE
    }
    /** Edit Text Filter to block Specified Special Char   */
    /* val filter: InputFilter = InputFilter { source, start, end, dest, dstart, dend ->
         AppUtil.Log("dstart $dstart  dend $dend source $source")
         *//*  if (source != null && IbeconConstant.blockCharacterSet.contains(("" + source))) {
                return "";
            }*//*
        if (source != null) {
            if (source != "" && source.toString().trim { it <= ' ' }.length != 0) {
                if (Constant.blockCharacterSet.contains("" + source[source.toString().trim { it <= ' ' }.length - 1])) {
                    if (PeopleHRApplicationContext.getContext() != null) {
                        Toast.makeText(, PeopleHRApplicationContext.getgActivity().getResources().getString(R.string.toast_specialCharacters), Toast.LENGTH_SHORT).show()
                    }
                    return@InputFilter source.subSequence(0, source.toString().trim { it <= ' ' }.length - 1)
                }
            }
        }
        null
        // return null;
    }*/


    object Filter{
        /** Edit Text Filter to block Specified Special Char   */
       /* val filter: InputFilter = InputFilter { source, start, end, dest, dstart, dend ->
            AppUtil.Log("dstart $dstart  dend $dend source $source")
            *//*  if (source != null && IbeconConstant.blockCharacterSet.contains(("" + source))) {
                 return "";
             }*//*
            if (source != null) {
                if (source != "" && source.toString().trim { it <= ' ' }.length != 0) {
                    if (Constants.blockCharacterSet.contains("" + source[source.toString().trim { it <= ' ' }.length - 1])) {
                        if (PeopleHRApplicationContext.getContext() != null) {
                            Toast.makeText(PeopleHRApplicationContext.getContext(), PeopleHRApplicationContext.getContext().getResources().getString(R.string.toast_specialCharacters), Toast.LENGTH_SHORT).show()
                        }
                        return@InputFilter source.subSequence(0, source.toString().trim { it <= ' ' }.length - 1)
                    }
                }
            }

            for (i in start until end) {
                val type = Character.getType(source[i])
                if (type == Character.SURROGATE.toInt() || type == Character.OTHER_SYMBOL.toInt()) {
                    return@InputFilter ""
                }
            }
            null
            // return null;
        }*/

        /*private inner class EmojiExcludeFilter : InputFilter {

            override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned, dstart: Int, dend: Int): CharSequence? {
                for (i in start until end) {
                    val type = Character.getType(source[i])
                    if (type == Character.SURROGATE.toInt() || type == Character.OTHER_SYMBOL.toInt()) {
                        return ""
                    }
                }
                return null
            }
        }*/
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    override fun checkVisibility(flag: Boolean)=if (flag) View.VISIBLE else View.GONE
}