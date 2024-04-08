package com.example.t4_221116955

import android.content.Context
import android.icu.text.NumberFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class OrderAdapter(
    val context: Context,
    val layout: Int,
    val orderList: ArrayList<Order>,
) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        //Note saya nyerah sama formatting object retard ini. Rp.XXX.XXX,XX is good enough.
        val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(Locale("in", "ID"))

        val orderId: TextView = view.findViewById(R.id.order_id)
        val orderName: TextView = view.findViewById(R.id.order_name)
        val orderPrice: TextView = view.findViewById(R.id.order_price)
        val orderStatus: TextView = view.findViewById(R.id.order_status)

        fun bind(order: Order) {
            orderId.text = "Order ${order.id}"
            orderName.text = order.order_name
            orderPrice.text = formatRupiah.format(order.price.toDouble()).toString()
            orderStatus.text = order.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(orderList[position])
    }
}

