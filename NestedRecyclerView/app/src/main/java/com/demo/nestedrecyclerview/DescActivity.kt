package com.demo.nestedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_desc.*

class DescActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desc)

        val data = intent.getParcelableExtra<LocationData>("loc_data")

        textViewName.text = data?.locationName

        var address = ""

        data?.address?.let {
            address += it +", "
        }
        data?.city?.let {
            address += it+", "
        }
        data?.state?.let {
            address += it+", "
        }
        data?.zip?.let {
            address += it+", "
        }
        data?.country?.let {
            address += it
        }
        textViewAddress.text = address


        Glide.with(imageview).load(data?.url).into(imageview)
    }
}