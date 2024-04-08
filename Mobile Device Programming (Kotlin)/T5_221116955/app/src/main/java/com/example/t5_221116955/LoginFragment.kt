package com.example.t5_221116955

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager

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

    lateinit var loginBtn:Button
    lateinit var toRegisterBtn:Button
    lateinit var usernameEt:EditText
    lateinit var passwordEt:EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    //tried removing the entire fucking menu because its a security issue if this were to be used for real.
//    override fun onPrepareOptionsMenu(menu: Menu) {
//        super.onPrepareOptionsMenu(menu) // this will work if this shit language doesn't fucking deprecate everything.
//        val item: MenuItem = menu.findItem(R.id.homeMenu)
//        val item2: MenuItem = menu.findItem(R.id.logoutMenu)
//        val item3: MenuItem = menu.findItem(R.id.publishMenu)
//        item.isVisible = false  // Set it to true if you want to show it
//        item2.isVisible = false  // Set it to true if you want to show it
//        item3.isVisible = false  // Set it to true if you want to show it
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginBtn = view.findViewById(R.id.loginBtn)
        toRegisterBtn = view.findViewById(R.id.toRegisterBtn)
        usernameEt = view.findViewById(R.id.usernameEt)
        passwordEt = view.findViewById(R.id.passwordEt)

        loginBtn.setOnClickListener {
            var username:String = usernameEt.text.toString()
            var password:String = passwordEt.text.toString()

            if(username.length>0 && password.length>0){
                if(MockDB.usernameExist(username)){ //if username is registered, proceed to login
                    var temp = MockDB.getUser(username)
                    Log.d("get pass", temp?.password.toString())
                    Log.d("entry pass",password)
                    if(temp!!.password != password){
                        val text = "Wrong Username/Password!"
                        val duration = Toast.LENGTH_SHORT
                        val toast = Toast.makeText(this.requireContext(), text, duration)
                        toast.show()
                    }
                    else{
                        val text = "Welcome, ${username}!"
                        val duration = Toast.LENGTH_SHORT
                        val toast = Toast.makeText(this.requireContext(), text, duration)
                        toast.show()
                        MockDB.currentUser = temp
                        findNavController().navigate(R.id.action_global_homeFragment) //move to home
                    }
                }
                else{
                    val text = "Wrong Username/Password!"
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

        toRegisterBtn.setOnClickListener {
            findNavController().navigate(R.id.action_global_registerFragment)
        }

    }


}