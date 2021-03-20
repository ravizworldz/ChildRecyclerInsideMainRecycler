package com.demo.nestedrecyclerview

import android.os.Parcel
import android.os.Parcelable

data class LocationList(val data: List<LocationData>)
data class LocationData(val locationName: String?,
                        val address: String?,
                        val city: String?,
                        val state: String?,
                        val zip: String?,
                        val country: String?,
                        val url: String?,
                        val childLocations: List<LocationData>?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(), null

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(locationName)
        parcel.writeString(address)
        parcel.writeString(city)
        parcel.writeString(state)
        parcel.writeString(zip)
        parcel.writeString(country)
        parcel.writeString(url)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LocationData> {
        override fun createFromParcel(parcel: Parcel): LocationData {
            return LocationData(parcel)
        }

        override fun newArray(size: Int): Array<LocationData?> {
            return arrayOfNulls(size)
        }
    }

}