package com.sprytech.vaccinepassport.ui.registration

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sprytech.vaccinepassport.R
import com.sprytech.vaccinepassport.databinding.ActivityHowItWorksBinding
import com.sprytech.vaccinepassport.databinding.ActivityRegistrationConfirmationBinding
import com.sprytech.vaccinepassport.ui.HomeActivity


class RegistrationConfirmationActivity : AppCompatActivity() {

    lateinit var binding : ActivityRegistrationConfirmationBinding

    private lateinit var layouts: IntArray

    private lateinit var dots: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_how_it_works)

         binding = DataBindingUtil.setContentView<ActivityRegistrationConfirmationBinding>(this, R.layout.activity_registration_confirmation)


        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

    }

    private fun addBottomDots(currentPage: Int) {

    }
}