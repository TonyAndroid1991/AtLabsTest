package com.y4kuzabanzai.atlabstest.models.userrepos


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserRepositoriesItem(
    @SerializedName("name")
    val name: String,
) : Serializable
