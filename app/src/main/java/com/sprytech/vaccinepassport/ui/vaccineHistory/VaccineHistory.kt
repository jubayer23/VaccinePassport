package com.sprytech.vaccinepassport.ui.vaccineHistory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sprytech.vaccinepassport.R
import com.sprytech.vaccinepassport.databinding.FragmentVaccineHistoryBinding
import com.sprytech.vaccinepassport.model.Vaccine

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VaccineHistory.newInstance] factory method to
 * create an instance of this fragment.
 */
class VaccineHistory : Fragment() {


    val animals: ArrayList<Vaccine> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_vaccine_history, container, false)

        val binding: FragmentVaccineHistoryBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_vaccine_history, container, false)


        binding.imgAdd.setOnClickListener {
            findNavController().navigate(R.id.patientRegisterFragment)
        }

        addAnimals()


        binding.recyclerView.adapter = activity?.let { NewInnerAdapter(animals, it) }
        binding.recyclerView.layoutManager = GridLayoutManager(activity, 2, RecyclerView.VERTICAL, false)

        //binding.recyclerView.listenForEndScroll(1) { viewModel.loadNextPage() }
       // binding.swipeRefresh.setOnRefreshListener { viewModel.refresh() }

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

              //  playAnimationLiveData.value = newState != RecyclerView.SCROLL_STATE_IDLE
            }
        })

        return binding.root
    }

    fun addAnimals() {
        animals.add(Vaccine(true,"Akhil","0.01", "12/32/11"))
        animals.add(Vaccine(true,"Mak","0.01", "12/32/11"))
        animals.add(Vaccine(true,"Pageh","0.01", "12/32/11"))
        animals.add(Vaccine(true,"Jubayer","0.01", "12/32/11"))
        animals.add(Vaccine(true,"Qaium","0.01", "12/32/11"))
        animals.add(Vaccine(true,"Viswa","0.01", "12/32/11"))
        animals.add(Vaccine(true,"Kishor","0.01", "12/32/11"))
        animals.add(Vaccine(true,"Robin","0.01", "12/32/11"))


    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                VaccineHistory()
    }
}