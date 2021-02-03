package com.sprytech.vaccinepassport.ui.registration.howItWorks

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sprytech.vaccinepassport.R
import com.sprytech.vaccinepassport.databinding.ActivityHowItWorksBinding


class HowItWorksActivity : AppCompatActivity() {

    lateinit var binding : ActivityHowItWorksBinding

    private lateinit var layouts: IntArray

    private lateinit var dots: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_how_it_works)

         binding = DataBindingUtil.setContentView<ActivityHowItWorksBinding>(this, R.layout.activity_how_it_works)


         layouts = intArrayOf(
            R.layout.howitworks_slide_1,
            R.layout.howitworks_slide_1
        )
    }

    private fun addBottomDots(currentPage: Int) {

    }
}