package com.samrans.labtest.ui.detailsservice


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.samrans.labtest.R
import com.samrans.labtest.ui.labselect.LabSelectActivity
import kotlinx.android.synthetic.main.activity_lab_select.*

/**
 * A simple [Fragment] subclass.
 */
class LabDetailsSelectFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lab_details_select, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity!! as LabSelectActivity).toolbar_title.setText("Service 1")
    }


}
