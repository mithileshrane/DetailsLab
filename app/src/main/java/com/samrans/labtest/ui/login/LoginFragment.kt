package com.samrans.labtest.ui.login


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.samrans.labtest.R
import com.samrans.labtest.ui.base.KodeinViewModelFactory
import com.samrans.labtest.ui.lablist.DashBoardActivity
import kotlinx.android.synthetic.main.fragment_login.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : Fragment(),KodeinAware {
    /**
     * A Kodein Aware class must be within reach of a [Kodein] object.
     */
    override val kodein by kodein()
    lateinit var mViewModel: LoginViewModel
    val factory: LoginViewModelFactory by instance()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        KodeinViewModelFactory(kodein)
        mViewModel=ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)

        fbNext?.setOnClickListener {
            if(validateLogin(edt_username?.text.toString(),edt_password?.text.toString())){
                val intent = Intent(activity, DashBoardActivity::class.java)

                startActivity(intent)
                activity!!.finish()
            }

        }


    }

    private fun validateLogin(edt_username: String, edt_password: String): Boolean {
        when{
            edt_username.isEmpty()->{
                Toast.makeText(activity!!,R.string.txt_invalid_username,Toast.LENGTH_SHORT).show()
                return false
            }

            edt_password.isEmpty()->{
                Toast.makeText(activity!!,R.string.txt_invalid_password,Toast.LENGTH_SHORT).show()
                return false
            }

            edt_password.length<5->{
                Toast.makeText(activity!!,R.string.txt_invalid_password_length,Toast.LENGTH_SHORT).show()
                return false
            }
            else->{
                return true
            }
        }
    }


}
