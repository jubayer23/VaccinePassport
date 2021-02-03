package com.sprytech.vaccinepassport.ui.registration

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.sprytech.vaccinepassport.R
import com.sprytech.vaccinepassport.databinding.FragmentEnterDocumentBinding
import com.sprytech.vaccinepassport.ui.registration.howItWorks.HowItWorksActivity2


/**
 * A simple [Fragment] subclass.
 * Use the [EnterDocumentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EnterDocumentFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentEnterDocumentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_enter_document, container, false)

        binding.btnUpload.setOnClickListener {

            //startActivity(Intent(activity, HowItWorksActivity2::class.java))
            findNavController().navigate(R.id.howItWorksFragment)


        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EnterDocumentFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EnterDocumentFragment()
    }
}