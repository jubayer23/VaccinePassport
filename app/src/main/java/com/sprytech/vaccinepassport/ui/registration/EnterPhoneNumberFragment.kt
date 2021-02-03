package com.sprytech.vaccinepassport.ui.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.sprytech.vaccinepassport.R
import com.sprytech.vaccinepassport.databinding.FragmentEnterPhoneNumberBinding
import com.sprytech.vaccinepassport.databinding.FragmentWelcomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EnterPhoneNumberFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EnterPhoneNumberFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentEnterPhoneNumberBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_enter_phone_number, container, false)

        binding.btnSubmit.setOnClickListener {
            findNavController().navigate(R.id.enterOtpFragment)
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
         * @return A new instance of fragment EnterPhoneNumberFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EnterPhoneNumberFragment()
    }
}