package com.sprytech.vaccinepassport.ui.patientRegister

import android.app.DatePickerDialog
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.sprytech.vaccinepassport.R
import com.sprytech.vaccinepassport.databinding.FragmentEnterOtpBinding
import com.sprytech.vaccinepassport.databinding.FragmentPatientRegisterBinding
import kotlinx.android.synthetic.main.fragment_patient_register.*
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PatientRegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PatientRegisterFragment : Fragment() {

   lateinit var  binding: FragmentPatientRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    var currentPage : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding= DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_patient_register, container, false)


        addBottomDots(currentPage)
        binding.llForm1.visibility = View.VISIBLE
        binding.llForm2.visibility = View.GONE
        binding.llForm3.visibility = View.GONE

        binding.edDob.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd = activity?.let { it1 ->
                DatePickerDialog(
                    it1,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                        // Display Selected date in textbox
                        ed_dob.setText("" + dayOfMonth + "/" + monthOfYear + "/" + year)

                    },
                    year,
                    month,
                    day
                )
            }

            dpd?.show()
        }

        binding.edVaccineDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd = activity?.let { it1 ->
                DatePickerDialog(
                    it1,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                        // Display Selected date in textbox
                        ed_vaccine_date.setText("" + dayOfMonth + "/" + monthOfYear + "/" + year)

                    },
                    year,
                    month,
                    day
                )
            }

            dpd?.show()
        }

        val slide_out = AnimationUtils.loadAnimation(activity, R.anim.slide_out_left)
        val slide_in = AnimationUtils.loadAnimation(activity, R.anim.slide_in_right)

        binding.btnNext.setOnClickListener {

                if(currentPage == 0){



                    binding.llForm1.startAnimation(slide_out)
                    Handler().postDelayed({
                        binding.llForm1.visibility = View.GONE
                        addBottomDots(++currentPage)
                    }, 100)

                    ll_form_2.visibility = View.VISIBLE
                    binding.llForm2.startAnimation(slide_in)
                }else if(currentPage == 1){
                        binding.llForm2.startAnimation(slide_out)
                        Handler().postDelayed({
                            binding.llForm2.visibility = View.GONE
                            addBottomDots(++currentPage)
                        }, 100)

                        ll_form_3.visibility = View.VISIBLE
                        binding.llForm3.startAnimation(slide_in)
                        loadData()
                 }
        }


        return binding.root
    }

    fun loadData(){

        binding.tvName.setText(ed_name.text.toString())
        binding.tvAddress.setText(ed_address.text.toString())
        binding.tvDateOfBirth.setText(ed_dob.text.toString())
        binding.tvVaccineName.setText(ed_name_of_vaccine.text.toString())
        binding.tvType.setText(ed_type.text.toString())
        binding.tvCompany.setText(ed_company.text.toString())
        binding.tvVaccineDate.setText(ed_vaccine_date.text.toString())

        btn_text.setText("Create Record")
    }

    private fun addBottomDots(currentPage: Int) {
        if (currentPage == 0) {


            binding.dot1.setImageDrawable(resources.getDrawable(R.drawable.ic_dot_active))
            binding.dot2.setImageDrawable(resources.getDrawable(R.drawable.ic_dot_inactive))
            binding.dot3.setImageDrawable(resources.getDrawable(R.drawable.ic_dot_inactive))
        } else if (currentPage == 1) {
            binding.dot1.setImageDrawable(resources.getDrawable(R.drawable.ic_dot_inactive))
            binding.dot2.setImageDrawable(resources.getDrawable(R.drawable.ic_dot_active))
            binding.dot3.setImageDrawable(resources.getDrawable(R.drawable.ic_dot_inactive))
        } else if (currentPage == 2) {
            binding.dot1.setImageDrawable(resources.getDrawable(R.drawable.ic_dot_inactive))
            binding.dot2.setImageDrawable(resources.getDrawable(R.drawable.ic_dot_inactive))
            binding.dot3.setImageDrawable(resources.getDrawable(R.drawable.ic_dot_active))
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PatientRegisterFragment()
    }
}