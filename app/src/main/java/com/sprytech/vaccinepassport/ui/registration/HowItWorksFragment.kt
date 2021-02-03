package com.sprytech.vaccinepassport.ui.registration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.sprytech.vaccinepassport.R
import com.sprytech.vaccinepassport.databinding.FragmentHowItWorksBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HowItWorksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HowItWorksFragment : Fragment() {
     lateinit var  layouts: IntArray
    private lateinit var myViewPagerAdapter: MyViewPagerAdapter



    lateinit var binding: FragmentHowItWorksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_how_it_works, container, false)

       binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_how_it_works, container, false)


        // layouts of welcome sliders
        layouts = intArrayOf(
            R.layout.howitworks_slide_1,
            R.layout.howitworks_slide_2,
            R.layout.howitworks_slide_3
        )

        myViewPagerAdapter =
            activity?.let { MyViewPagerAdapter(it, layouts) }!!
        binding.viewPager.setAdapter(myViewPagerAdapter)
        binding.viewPager.addOnPageChangeListener(viewPagerPageChangeListener)


        // adding bottom dots
        addBottomDots(0)
        /* btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //launchHomeScreen();
            }
        });*/
        binding.btnNext.setOnClickListener(View.OnClickListener {
            // checking for last page if true launch MainActivity
            val current = getItem(+1)
            if (current < layouts.size) {
                // move to next screen
                binding.viewPager.setCurrentItem(current)
            } else {
                //launchHomeScreen();
                startActivity(
                    Intent(
                        activity,
                        RegistrationConfirmationActivity::class.java
                    )
                )
            }
        })

      return  binding.root
    }


    private fun getItem(i: Int): Int {
        return binding.viewPager.getCurrentItem() + i
    }

    //  viewpager change listener
    var viewPagerPageChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            addBottomDots(position)

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.size - 1) {
                // last page. make button text to GOT IT
                // btnNext.setText("Start");
                // btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                // btnNext.setText("Next");
                // btnSkip.setVisibility(View.VISIBLE);
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
        override fun onPageScrollStateChanged(arg0: Int) {}
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


    /**
     * View pager adapter
     */
    class MyViewPagerAdapter( private val context: Context, var  layouts: IntArray) : PagerAdapter() {
        private var layoutInflater: LayoutInflater? = null
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
            val view: View =
                layoutInflater!!.inflate(layouts.get(position), container, false)
            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return layouts.size
        }

        override fun isViewFromObject(
            view: View,
            obj: Any
        ): Boolean {
            return view === obj
        }

        override fun destroyItem(
            container: ViewGroup,
            position: Int,
            `object`: Any
        ) {
            val view = `object` as View
            container.removeView(view)
        }
    }

   

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HowItWorksFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HowItWorksFragment()
    }
}