package com.example.t4_221116955

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    val context: Context,
    val layout: Int,
    val menuList: ArrayList<Menu>,
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val menuName: TextView = view.findViewById(R.id.menuName)
        val menuPrice: TextView = view.findViewById(R.id.menuPrice)
        val deleteMenuBtn:ImageView = view.findViewById(R.id.deleteMenuBtn)
        val editMenuBtn:ImageView =  view.findViewById(R.id.editMenuBtn)


        fun bind(menu: Menu) {
            menuName.text = menu.nama
            menuPrice.text = "Rp. ${menu.price}"

            deleteMenuBtn.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    MenuRepository.listOrder.removeAt(position)
                    notifyItemRemoved(position)
                }
            }

            editMenuBtn.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val intent = Intent(context, EditMenuActivity::class.java)
                    intent.putExtra("position", position)
                    context.startActivity(intent)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menuList[position])
    }
}