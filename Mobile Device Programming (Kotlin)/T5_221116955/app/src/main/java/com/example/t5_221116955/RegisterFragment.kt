package com.example.t5_221116955

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    lateinit var registerBtn: Button
    lateinit var toLoginBtn: Button
    lateinit var displayNameEt:EditText
    lateinit var usernameEt: EditText
    lateinit var passwordEt: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerBtn = view.findViewById(R.id.registerBtn)
        toLoginBtn = view.findViewById(R.id.toLoginBtn)
        displayNameEt = view.findViewById(R.id.displayNameEt)
        usernameEt = view.findViewById(R.id.usernameEt)
        passwordEt = view.findViewById(R.id.passwordEt)

        registerBtn.setOnClickListener {
            var displayName:String = displayNameEt.text.toString()
            var username:String = usernameEt.text.toString()
            var password:String = passwordEt.text.toString()

            if(displayName.length>0 && username.length>0 && password.length>0){
                if(!MockDB.usernameExist(username)){ //if username is unique, add them to the list
                    MockDB.addUser(User(displayName,username,password))
                    val text = "Register Successful"
                    val duration = Toast.LENGTH_SHORT
                    //this is fucking stupid. Why the actual hell did this not refer to the context of self?
                    val toast = Toast.makeText(this.requireContext(), text, duration)
                    toast.show()
                }
                else{
                    val text = "Username is not unique!"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(this.requireContext(), text, duration)
                    toast.show()
                }
            }
            else{
                val text = "Missing values!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this.requireContext(), text, duration)
                toast.show()
            }


        }

        toLoginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_global_loginFragment)
        }

    }

}