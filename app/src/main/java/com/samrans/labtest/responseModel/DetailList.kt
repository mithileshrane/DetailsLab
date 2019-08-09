package com.samrans.labtest.responseModel

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
class DetailList {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    var labId:String?=null

    @ColumnInfo(name = "title")
    @SerializedName("Title")
    @Expose
    var mTitle:String?=null

    @ColumnInfo(name = "status")
    @SerializedName("Status")
    @Expose
    var mStatus:String?=null

    @ColumnInfo(name = "description")
    @SerializedName("Description")
    @Expose
    var mDescription:String?=null

}