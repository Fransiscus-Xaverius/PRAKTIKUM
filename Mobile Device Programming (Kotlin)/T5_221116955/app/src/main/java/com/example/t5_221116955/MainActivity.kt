package com.example.t5_221116955

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity() {

    private lateinit var container: FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        container = findViewById(R.id.fragment_container)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.homeMenu->{
                if(MockDB.currentUser!=null){
                    container.getFragment<Fragment>().findNavController().navigate(R.id.action_global_homeFragment)
                }
                else{
                    val text = "You're not logged in!"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(this, text, duration)
                    toast.show()
                }
            }
            R.id.publishMenu->{
                if(MockDB.currentUser!=null){
                    container.getFragment<Fragment>().findNavController().navigate(R.id.action_global_publishFragment)
                }
                else{
                    val text = "You're not logged in!"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(this, text, duration)
                    toast.show()
                }
            }
            R.id.logoutMenu->{
                MockDB.currentUser = null
                container.getFragment<Fragment>().findNavController().navigate(R.id.action_global_loginFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}