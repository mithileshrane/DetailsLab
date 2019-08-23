package com.samrans.labtest.ui.labselect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.samrans.labtest.R
import com.samrans.labtest.responseModel.DetailList
import com.samrans.labtest.ui.listeners.OnClickListenerWithPositionType

class LabSelectListAdapter(
    val filteredList: ArrayList<DetailList>
    , val listener: OnClickListenerWithPositionType
) :
    RecyclerView.Adapter<LabSelectListAdapter.DataHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LabSelectListAdapter.DataHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_lab_select, parent, false)
        return LabSelectListAdapter.DataHolder(v)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun onBindViewHolder(holder: LabSelectListAdapter.DataHolder, position: Int) {
        val labListModel = filteredList.get(position)
//        holder.tv_sublabtitle.text = labListModel.mTitle

        holder.itemView.setOnClickListener {
            listener.onClickItem(labListModel, -1, R.layout.item_lab)
        }
    }

    class DataHolder(itemViewHolder: View) : RecyclerView.ViewHolder(itemViewHolder) {
        val tv_sublabtitle = itemView.findViewById<TextView>(R.id.tv_sublabtitle)
        val iv_image_back = itemView.findViewById<ImageView>(R.id.iv_image_back)
    }
}