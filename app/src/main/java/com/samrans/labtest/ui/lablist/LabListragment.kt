package com.samrans.labtest.ui.lablist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.samrans.labtest.R
import com.samrans.labtest.responseModel.DetailList
import com.samrans.labtest.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_lab_listragment.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LabListragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 *
 */
class LabListragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lab_listragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showData()
    }

    private lateinit var labListAdapter: LabListAdapter
    private var items = ArrayList<DetailList>()

    private fun showData() {
        val mLayoutManager = LinearLayoutManager(activity!!)

        createList()
        labListAdapter=LabListAdapter(items)

        recylView?.layoutManager = mLayoutManager
        recylView?.adapter = labListAdapter


    }

    private fun createList() {
        val detailList1= DetailList()
        detailList1.mTitle="Lab 1"
        detailList1.mStatus="08.30 am"
        items.add(detailList1)

        val detailList2= DetailList()
        detailList2.mTitle="Lab 2"
        detailList2.mStatus="09.45 am"
        items.add(detailList2)

        val detailList3= DetailList()
        detailList3.mTitle="Lab 3"
        detailList3.mStatus="10.00 am"
        items.add(detailList3)

        val detailList4= DetailList()
        detailList4.mTitle="Lab 4"
        detailList4.mStatus="11.30 am"
        items.add(detailList4)

        val detailList5= DetailList()
        detailList5.mTitle="Lab 5"
        detailList5.mStatus="01.30 pm"
        items.add(detailList5)


    }


}
