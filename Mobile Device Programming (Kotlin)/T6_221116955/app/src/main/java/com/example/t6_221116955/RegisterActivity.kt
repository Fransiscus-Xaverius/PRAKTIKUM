package com.example.t6_221116955

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.t6_221116955.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var registerBtn: Button
    private lateinit var toLoginBtn: Button
    private lateinit var displayNameEt:EditText
    private lateinit var usernameEt:EditText
    private lateinit var passwordEt:EditText
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerBtn = binding.registerBtn
        toLoginBtn = binding.toLoginBtn
        displayNameEt = binding.displayNameEt
        usernameEt = binding.usernameRegisterEt
        passwordEt = binding.passwordRegisterEt
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        toLoginBtn.setOnClickListener {
            // Navigate to MainActivity
            finish()
        }

        registerBtn.setOnClickListener {
            // Create new user
            val tempDisplayName: String = displayNameEt.text.toString()
            val tempUsername: String = usernameEt.text.toString()
            val tempPassword: String = passwordEt.text.toString()
            val success = userViewModel.createUser(tempUsername, tempPassword, tempDisplayName)
            // Navigate to MainActivity
            if(success){
                finish()
            }
            else{
                // Display error message
                Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show()
            }
        }

    }
}