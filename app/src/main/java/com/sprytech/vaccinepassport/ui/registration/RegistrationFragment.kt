package com.sprytech.vaccinepassport.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.sprytech.vaccinepassport.R
import com.sprytech.vaccinepassport.databinding.FragmentRegistration2Binding
import com.sprytech.vaccinepassport.databinding.FragmentWelcomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentRegistration2Binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_registration_2, container, false)
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_registration_2, container, false)

        binding.btnSignup.setOnClickListener {
            findNavController().navigate(R.id.enterPhoneNumberFragment)
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistrationFragment()
    }
}