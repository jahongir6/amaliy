package com.example.amaliy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.amaliy.R
import com.example.amaliy.databinding.FragmentAddBinding
import com.example.amaliy.db.MyDbHelper
import com.example.amaliy.models.User

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)
        myDbHelper = MyDbHelper(binding.root.context)
        binding.btnSave.setOnClickListener {
            val user = User(
                0,
                binding.edtName.text.toString(),
                binding.edtAge.text.toString().toInt(),
                binding.mySpinner.selectedItemPosition
            )
            myDbHelper.addUser(user)
            Toast.makeText(context, "save", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}