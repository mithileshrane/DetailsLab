package com.samrans.labtest.ui.lablist

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.samrans.labtest.R
import com.samrans.labtest.ui.base.BaseActivity

import kotlinx.android.synthetic.main.activity_dash_board.*

class DashBoardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        setSupportActionBar(toolbar)

        toolbar.setTitle(R.string.txt_lab_list)
        setSupportActionBar(toolbar);
        toolbar_title.setText(toolbar.getTitle())

        getSupportActionBar()?.setDisplayShowTitleEnabled(false)
        addFragment(R.id.framContainerInner,LabListragment(),
            LabListragment::class.java.simpleName!!,false)


    }

}
