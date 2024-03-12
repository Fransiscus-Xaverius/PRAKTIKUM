package com.example.m1_221116955

import kotlin.random.Random

fun main(){
    var uang = 1000
    var order_done = 0
    var day = 1

    var biji:Int = 20
    var air:Int = 10
    var susu:Int = 20

    var bijiP:Int = 40
    var airP:Int = 25
    var susuP:Int = 60

    val orders = mutableListOf<Array<Int>>()

    var game = true

    while(game){
        menu(uang, order_done, day)

        var opt:Int? = readlnOrNull()!!.toIntOrNull()
        if(opt == 1){
            showStock(biji,air,susu)
        }
        else if(opt == 2){
            var buying = true
            while(buying) {
                buyMenu()
                var buyOpt: Int? = readlnOrNull()!!.toIntOrNull()
                //SYNTAX KHUSUS KOTLIN 1, ELVIS OPERATOR
                buyOpt?.let {
                    if(buyOpt!!>0 && buyOpt!!<4){
                        var priceOfItem:Int? = -1
                        var buyAmount: Int? = -1
                        //SYNTAX KHUSUS KOTLIN 2, WHEN EXPRESSION
                        when(buyOpt!!){
                            1 -> priceOfItem = 30
                            2 -> priceOfItem = 20
                            3 -> priceOfItem = 50
                        }
                        print("Jumlah : ")
                        buyAmount = readlnOrNull()!!.toIntOrNull()
                        buyAmount?.let{
                            var totalAmount:Int? = priceOfItem!!.toInt()*buyAmount!!.toInt()
                            totalAmount?.let{
                                if(totalAmount!!<=uang){
                                    print("Pembelian Sukses, uang berkurang ${totalAmount}G")
                                    uang-=totalAmount
                                    when(buyOpt){
                                        1 -> {
                                            biji+=buyAmount
                                        }
                                        2 -> {
                                            air+=buyAmount
                                        }
                                        3 -> {
                                            susu+=buyAmount
                                        }
                                    }
                                }
                                else{
                                    print("Pembelian gagal, uang tidak cukup")
                                }
                            }
                        }
                        buyAmount?:run{
                            print("Pembelian Gagal, buyAmount is null")
                        }
                    }
                    else if(buyOpt == 4){
                        buying = false
                    }
                    else{
                        println("Invalid input, tolong masukkan input yang sesuai!")
                    }
                }
                buyOpt ?: run {
                    println("Invalid input, tolong masukkan input yang sesuai")
                }
            }
        }
        else if(opt == 3){
            var takingOrders:Boolean = true
            while(takingOrders){
                pesananMenu()
                var orderOpt:Int? = readlnOrNull()!!.toIntOrNull()
                orderOpt?.let {
                    if(orderOpt!! == 1) {
                        var jumbiji:Int = randNum(4)
                        var jumair:Int = randNum(4)
                        var jumsusu:Int = randNum(4)
                        orders.add(arrayOf(jumbiji,jumair,jumsusu))
                        print("Pesanan baru : ${jumbiji} Kopi + ${jumair} Air + ${jumsusu}")
                    }
                    else if(orderOpt!! == 2){
                        println("Daftar Pesanan:")
                        var i:Int = 1
                        for (order in orders){
                            println("${i}. ${order[0]} Kopi + ${order[1]} Air + ${order[2]} Susu")
                            i++
                        }
                    }
                    else if(orderOpt!! == 3){
                        var finishingOrder:Boolean = true
                        while(finishingOrder){
                            println("Selesaikan Pesanan: ")
                            var i:Int = 1
                            for (order in orders){
                                println("${i}. ${order[0]} Kopi + ${order[1]} Air + ${order[2]} Susu")
                                i++
                            }
                            println("0. Batal")
                            print("Input Selesaikan Pesanan : ")
                            var finishOpt: Int? = readlnOrNull()!!.toIntOrNull()
                            finishOpt?.let {
                                if(finishOpt == 0){
                                    finishingOrder = false
                                }
                                else{
                                    if(finishOpt<=orders.size && finishOpt>0){
                                        if(orders[finishOpt-1][0]<=biji && orders[finishOpt-1][1]<=air && orders[finishOpt-1][2]<=susu){
                                            var tprice:Int = (orders[finishOpt-1][0]*bijiP)+(orders[finishOpt-1][1]*airP)+(orders[finishOpt-1][2]*susuP)
                                            biji-=orders[finishOpt-1][0]
                                            air-=orders[finishOpt-1][1]
                                            susu-=orders[finishOpt-1][2]
                                            println("Pesanan diselesaikan! Uang bertambah ${tprice}G")
                                            uang+=tprice
                                            orders.removeAt(finishOpt-1)
                                            order_done++
                                        }
                                        else{
                                            println("Bahan tidak cukup untuk menyelesaikan pesanan!")
                                        }
                                    }
                                    else{
                                        println("Input tidak valid!, tolong masukkan input yang valid!")
                                    }
                                }
                            }
                            finishOpt?:run{
                                println("Input tidak valid!, tolong masukkan input yang valid!")
                            }
                        }
                    }
                    else if(orderOpt!! == 4){
                        takingOrders = false
                    }
                    else{
                        print("Invalid input! Tolong masukkan input yang sesuai")
                    }
                }
                orderOpt?:run{
                    print("Invalid input! Tolong masukkan input yang sesuai")
                }
            }
        }
        else if(opt == 4){
            day++
            var total_amount:Int = order_done*20
            order_done = 0
            println("Hari berganti, jumlah pesanan yang diselesaikan sebanyak ${order_done}, sehingga uang bertambah ${total_amount}G")
            uang+=total_amount
        }
        else if(opt == 5){
            biji+=5
            air+=5
            susu+=5
            println("Ngecheat mulu. Lemah.")
        }
        else if(opt == 6){
            game = false
        }
        else{
            println("Input salah. Silahkan masukkan input kembali!")
        }
    }
}

fun showStock(biji:Int?, air:Int?, susu:Int?){
    println("Daftar Bahan :")
    println("Biji Kopi: ${biji}")
    println("Air : ${air}")
    println("Susu : ${susu}")
}

fun menu(uang:Int, jumlahorder:Int, hari:Int) {
    println("Uang : ${uang}G")
    println("Jumlah Order Terpenuhi : ${jumlahorder}")
    println("Hari : ${hari}")
    println("Menu:")
    println("1. Lihat Stok")
    println("2. Beli Bahan")
    println("3. Pesanan")
    println("4. Ganti Hari")
    println("5. Cheat")
    println("6. Exit")
    print(">>")
}

fun buyMenu(){
    println("Beli Bahan:")
    println("1. Biji Kopi - 30G")
    println("2. Air - 20G")
    println("3. Susu - 50G")
    println("4. Back to Main Menu")
    print("Inputan : ")
}
//SYNTAX KHUSUS KOTLIN 3, Compact Function
fun randNum(limit:Int):Int = Random(System.currentTimeMillis()).nextInt(1, limit)

fun pesananMenu(){
    println("Pesanan")
    println("1. Terima Pesanan")
    println("2. Lihat Pesanan")
    println("3. Selesaikan Pesanan")
    println("4. Back to Main Menu")
    print("Input Pesanan : ")
}

