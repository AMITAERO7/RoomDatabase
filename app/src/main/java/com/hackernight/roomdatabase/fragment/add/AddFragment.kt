package com.hackernight.roomdatabase.fragment.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hackernight.roomdatabase.R
import com.hackernight.roomdatabase.UserViewModel
import com.hackernight.roomdatabase.data.User
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {

    private lateinit var mviewModel : UserViewModel
    private lateinit var mbuttonSubmit : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_add, container, false)

        mviewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        mbuttonSubmit = view.findViewById(R.id.buttonSubmit)

        mbuttonSubmit.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        mviewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val firstName  = editTextFirstN.text.toString()
        val lastName = editTextLastN.text.toString()
        val age =  editTextAge.text.toString()

        if (inputCheck(firstName,lastName,age)){
            val user = User(0,firstName,lastName,Integer.parseInt(age))
            //Add user to database
            mviewModel.addUser(user)
            //navigate back
            findNavController().navigate(R.id.navigateToListFragment)
        }else{
            Toast.makeText(requireContext(),"Please fill out the details!!!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: String): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(age))
    }

}