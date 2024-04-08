package com.example.t4_221116955

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.t4_221116955.databinding.ActivityAddMenuBinding

class AddMenuActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddMenuBinding

    private lateinit var menuNameText:TextView
    private lateinit var menuPriceText:TextView

    private lateinit var doneBtn:Button
    private lateinit var backBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_menu)
        binding = ActivityAddMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        menuNameText = binding.MenuNameText
        menuPriceText = binding.menuPriceText

        doneBtn = binding.doneAddMenuBtn
        backBtn = binding.addMenuBackBtn

        doneBtn.setOnClickListener {
            if(menuNameText.text.isNotEmpty() && menuPriceText.text.isNotEmpty()){
                if(isNumericUsingRegex(menuPriceText.text.toString())){
                    MenuRepository.listOrder.add(Menu(menuNameText.text.toString(), menuPriceText.text.toString().toInt()))
                    val targetIntent = Intent(this@AddMenuActivity, MenuActivity::class.java)
                    startActivity(targetIntent)
                }
                else{
                    showToast("Price Input must be of a valid number")
                }
            }
        }
        backBtn.setOnClickListener {
            onBackPressed()
        }

    }
    fun isNumericUsingRegex(toCheck: String): Boolean {
        val regex = "-?[0-9]+(\\.[0-9]+)?"
        return toCheck.matches(regex.toRegex())
    }
    fun Context.showToast(message: CharSequence) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}