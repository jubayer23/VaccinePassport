package com.sprytech.vaccinepassport.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.mindorks.retrofit.coroutines.data.api.RetrofitBuilder
import com.mindorks.retrofit.coroutines.ui.base.ViewModelFactory
import com.mindorks.retrofit.coroutines.utils.Status
import com.sprytech.vaccinepassport.ui.HomeActivity
import com.sprytech.vaccinepassport.R
import com.sprytech.vaccinepassport.databinding.FragmentLogin2Binding
import com.sprytech.vaccinepassport.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this,
                activity?.let { ViewModelFactory(RetrofitBuilder.apiService, it) }).get(LoginViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLogin2Binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login_2, container, false)

        binding.viewModel = viewModel

        binding.tvSingup.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment2)
            //findNavController().navigate(R.id.registrationFragment)

        }

        binding.btnLogin.setOnClickListener {
            //startActivity(Intent(activity, HomeActivity::class.java))
            login()

        }




        return binding.root
    }

    fun login(){

        activity?.let {
            viewModel.login().observe(it, Observer {
            it?.let {
                resource ->

                when(resource.status){
                    Status.SUCCESS -> {
                        progressBar.visibility = View.GONE

                        resource.data?.let { userProfile ->

                            if(userProfile.status){
                                viewModel.saveProfile(userProfile)
                                startActivity(Intent(activity, HomeActivity::class.java))
                                activity?.finish()
                            }
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(activity, "Invalid account credentials", Toast.LENGTH_LONG).show()
                        progressBar.visibility = View.GONE
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment()
    }
}