package com.example.amaliy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.amaliy.R
import com.example.amaliy.adapter.UserAdapter
import com.example.amaliy.databinding.FragmentItemViewPaagerBinding
import com.example.amaliy.db.MyDbHelper
import com.example.amaliy.models.User

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"


/**
 * A simple [Fragment] subclass.
 * Use the [ItemViewPaagerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ItemViewPaagerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var asosiymi: Boolean? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            asosiymi = it.getBoolean(ARG_PARAM1)
        }
    }

    private lateinit var binding: FragmentItemViewPaagerBinding
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var userAdapter: UserAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemViewPaagerBinding.inflate(layoutInflater)
        myDbHelper = MyDbHelper(requireContext())
        val list = myDbHelper.getAllUser()
        val list2 = ArrayList<User>()
        if (asosiymi!!){
            list.forEach{
                if (it.zaxirami==0){
                    list2.add(it)
                }
            }
        }else{
            list.forEach{
                if (it.zaxirami==1){
                    list2.add(it)
                }
            }
        }
        binding.rv.adapter = UserAdapter(list2)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param asosiymi Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ItemViewPaagerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(asosiymi: Boolean) =
            ItemViewPaagerFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_PARAM1, asosiymi)
                }
            }
    }
}