package com.samrans.labtest.ui.labselect

import android.os.Bundle
import com.samrans.labtest.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_lab_select.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.MenuItem
import com.samrans.labtest.R


class LabSelectActivity:BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_select)
        setSupportActionBar(toolbar)

        toolbar.setTitle(R.string.txt_lab_list)
        setSupportActionBar(toolbar)
        toolbar_title.setText(toolbar.getTitle())

        getSupportActionBar()?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val fragment=LabSelectFragment()

        if (intent!!.hasExtra("POS")){
            val bundle=Bundle()
            bundle.putString("POS",intent!!.getStringExtra("POS"))
            fragment.arguments=bundle
        }

        replaceFragment(R.id.framContainerInner,fragment,
            LabSelectFragment::class.java.simpleName!!,false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.getItemId() === android.R.id.home) {
            super.onBackPressed() // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item)
    }
}