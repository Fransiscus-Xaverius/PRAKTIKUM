package com.example.t6_221116955

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.t6_221116955.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //note:
    //this app does not use dataBinding because it wont fucking work :)
    //tried to remove everything and forcing it to sync on build.gradle, ended up wasting 1 hour to remake HomeActivity
    //because the shitty plugin makes the entire program just die and the generated build files to be corrupted :)
    //fuck android and its shitty system of build options.

    private lateinit var binding: ActivityMainBinding
    private lateinit var loginBtn: Button
    private lateinit var toRegisterBtn: Button
    private lateinit var usernameEt:EditText
    private lateinit var passwordEt:EditText
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginBtn = binding.loginBtn
        toRegisterBtn = binding.toRegisterBtn
        usernameEt = binding.usernameLoginEt
        passwordEt = binding.passwordLoginEt
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        loginBtn.setOnClickListener {
            // Navigate to HomeActivity
            val tempUsername: String = usernameEt.text.toString()
            val tempPassword: String = passwordEt.text.toString()
            val user = userViewModel.loginUser(tempUsername, tempPassword)
            if (user != null) {
                // Navigate to HomeActivity
                dataObj.curUser = user
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        toRegisterBtn.setOnClickListener {
            // Navigate to RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}