package com.samrans.labtest.ui.lablist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.samrans.labtest.R
import com.samrans.labtest.responseModel.DetailList
import com.samrans.labtest.ui.listeners.OnClickListenerWithPositionType

class LabListAdapter(val filteredList:ArrayList<DetailList>
                     ,val listener: OnClickListenerWithPositionType):
    RecyclerView.Adapter<LabListAdapter.DataHolder>() {

    class DataHolder(itemViewHolder: View) : RecyclerView.ViewHolder(itemViewHolder)  {
        val tv_lab_title = itemView.findViewById<TextView>(R.id.tv_lab_title)
        val tv_Status = itemView.findViewById<TextView>(R.id.tv_Status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LabListAdapter.DataHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_lab, parent, false)
        return LabListAdapter.DataHolder(v)
    }

    override fun getItemCount(): Int {
       return filteredList.size
    }

    override fun onBindViewHolder(holder: LabListAdapter.DataHolder, position: Int) {
        val labListModel = filteredList.get(position)
        holder.tv_lab_title.text = labListModel.mTitle
        holder.tv_Status.text = labListModel.mStatus

        holder.itemView.setOnClickListener {
            listener.onClickItem(labListModel, -1, R.layout.item_lab)
        }
    }
}