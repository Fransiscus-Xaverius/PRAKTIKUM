package com.example.t3_221116955

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val list_words = listOf(
        "BEBEK", "ANGSA", "KOTOR", "SERTA", "JARAK", "HUKUM", "RANCU", "SEMUA", "GULAI", "SENJA", "HARUM", "DAWAI",
        "MALAM", "BULAN", "BUNGA", "CALON", "ANTIK", "SERTA", "DAPAT", "ADUAN", "ABADI", "ABJAD", "ACARA", "AGAMA",
        "AJAIB", "KOKOH", "BADAK", "BADAI", "BADAN", "BAGUS", "ANCAM", "RAPAT", "LEPAS", "BALON", "GALON", "GADAI",
        "BUTIK", "DALAM", "PELAN"
    )

    var guess_word:String = ""
    var x:Int = 0
    var y:Int = 0
    var win:Boolean = false
    var skor:Int = 0
    var lose:Boolean = false

    private var buttonRow1: ArrayList<Button> = arrayListOf()
    private var buttonRow2: ArrayList<Button> = arrayListOf()
    private var buttonRow3: ArrayList<Button> = arrayListOf()
    private var buttonRow4: ArrayList<Button> = arrayListOf()
    private var buttonRow5: ArrayList<Button> = arrayListOf()

    private var guess_list: ArrayList<String> = arrayListOf()

    private lateinit var buttonRows: ArrayList<ArrayList<Button>>

    private lateinit var word : String

    //Keyboard button
    private lateinit var AButton: Button
    private lateinit var BButton: Button
    private lateinit var CButton: Button
    private lateinit var DButton: Button
    private lateinit var EButton: Button
    private lateinit var FButton: Button
    private lateinit var GButton: Button
    private lateinit var HButton: Button
    private lateinit var IButton: Button
    private lateinit var JButton: Button
    private lateinit var KButton: Button
    private lateinit var LButton: Button
    private lateinit var MButton: Button
    private lateinit var NButton: Button
    private lateinit var OButton: Button
    private lateinit var PButton: Button
    private lateinit var QButton: Button
    private lateinit var RButton: Button
    private lateinit var SButton: Button
    private lateinit var TButton: Button
    private lateinit var UButton: Button
    private lateinit var VButton: Button
    private lateinit var WButton: Button
    private lateinit var XButton: Button
    private lateinit var YButton: Button
    private lateinit var ZButton: Button

    //WarningTextView
    private lateinit var warningTextView:TextView
    //SkorTextView
    private lateinit var skorTextView: TextView

    //Util Button
    private lateinit var clearBtn: Button
    private lateinit var enterBtn: Button
    private lateinit var okButton: Button
    private lateinit var resetBtn: Button

    var error:Boolean = false

    fun handleButtonClick(c:Char){
        if(!error && !win && !lose){
            if(x<5){
                buttonRows.elementAt(y).elementAt(x).setText(c.toString())
                guess_word += c.toString()
                x++
            }
        }
    }

    fun handleClearClick(){
        if(x>0){
            x--
            buttonRows.elementAt(y).elementAt(x).setText(" ")
            guess_word = guess_word.dropLast(1)
        }
    }

    fun handleEnterClick(){
        if(!win && !lose){
            win = true
            if(guess_word.length==5){
                error = true
                for (i in 0..(word.length-1)){
                    if(word[i] == guess_word[i]){
                        buttonRows.elementAt(y).elementAt(i).setBackgroundColor(Color.GREEN)
                        error = false
                    }
                    else{
                        win = false
                    }
                }
                if(!win){
                    if(error){
                        warningTextView.setText("KATA TIDAK DITEMUKAN!")
                    }
                    else{
                        y++
                        x=0
                        guess_word = ""
                        guess_list.add(guess_word)
                        if(guess_list.size>4){
                            lose = true
                        }
                    }
                }
                else{
                    warningTextView.setText("BERHASIL MENEBAK KATA \n JAWABAN $word")
                    skor++
                    skorTextView.setText("Skor : $skor")
                }
            }
            else{
                warningTextView.setText("BARIS HARUS PENUH")
                error = true
            }
        }
        if(lose){
            warningTextView.setText("GAGAL MENEBAK KATA!\nJAWABAN : $word")

        }
    }

    fun handleOkClick(){
        if(error){
            error = false
            warningTextView.setText(" ")
        }
        if(lose){
            var intent:Intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("skor", skor)
            startActivity(intent)
        }
    }

    fun handleResetClick(){
        if(!lose){
            for (row in buttonRows){
                for(e in row){
                    e.setText(" ")
                    e.setBackgroundColor(Color.GRAY)
                }
            }
            win = false
            error = false
            warningTextView.setText(" ")
            guess_word = ""
            x = 0
            y = 0
            word = list_words.asSequence().shuffled().find { true }.toString()
            guess_list = arrayListOf()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Controls
        clearBtn = findViewById(R.id.ClearBtn)
        clearBtn.setBackgroundColor(Color.RED)
        clearBtn.setOnClickListener {
//            Log.d("Button Clear Message", "Clear Button Pressed")
            if(!error && !lose){
                handleClearClick()
            }
        }
        enterBtn = findViewById(R.id.EnterBtn)
        enterBtn.setOnClickListener {
            if(!error && !lose){
                handleEnterClick()
            }
        }
        okButton = findViewById(R.id.okButton)
        okButton.setOnClickListener {
            handleOkClick()
        }
        resetBtn = findViewById(R.id.resetButton)
        resetBtn.setOnClickListener {
            handleResetClick()
        }


        //Keyboard buttons
        AButton = findViewById(R.id.ABtn)
        BButton = findViewById(R.id.BBtn)
        CButton = findViewById(R.id.CBtn)
        DButton = findViewById(R.id.DBtn)
        EButton = findViewById(R.id.EBtn)
        FButton = findViewById(R.id.FBtn)
        GButton = findViewById(R.id.GBtn)
        HButton = findViewById(R.id.HBtn)
        IButton = findViewById(R.id.IBtn)
        JButton = findViewById(R.id.JBtn)
        KButton = findViewById(R.id.KBtn)
        LButton = findViewById(R.id.LBtn)
        MButton = findViewById(R.id.MBtn)
        NButton = findViewById(R.id.NBtn)
        OButton = findViewById(R.id.OBtn)
        PButton = findViewById(R.id.PBtn)
        QButton = findViewById(R.id.QBtn)
        RButton = findViewById(R.id.RBtn)
        SButton = findViewById(R.id.SBtn)
        TButton = findViewById(R.id.TBtn)
        UButton = findViewById(R.id.UBtn)
        VButton = findViewById(R.id.VBtn)
        WButton = findViewById(R.id.WBtn)
        XButton = findViewById(R.id.XBtn)
        YButton = findViewById(R.id.YBtn)
        ZButton = findViewById(R.id.ZBtn)
        AButton.setOnClickListener { handleButtonClick('A') }
        BButton.setOnClickListener { handleButtonClick('B') }
        CButton.setOnClickListener { handleButtonClick('C') }
        DButton.setOnClickListener { handleButtonClick('D') }
        EButton.setOnClickListener { handleButtonClick('E') }
        FButton.setOnClickListener { handleButtonClick('F') }
        GButton.setOnClickListener { handleButtonClick('G') }
        HButton.setOnClickListener { handleButtonClick('H') }
        IButton.setOnClickListener { handleButtonClick('I') }
        JButton.setOnClickListener { handleButtonClick('J') }
        KButton.setOnClickListener { handleButtonClick('K') }
        LButton.setOnClickListener { handleButtonClick('L') }
        MButton.setOnClickListener { handleButtonClick('M') }
        NButton.setOnClickListener { handleButtonClick('N') }
        OButton.setOnClickListener { handleButtonClick('O') }
        PButton.setOnClickListener { handleButtonClick('P') }
        QButton.setOnClickListener { handleButtonClick('Q') }
        RButton.setOnClickListener { handleButtonClick('R') }
        SButton.setOnClickListener { handleButtonClick('S') }
        TButton.setOnClickListener { handleButtonClick('T') }
        UButton.setOnClickListener { handleButtonClick('U') }
        VButton.setOnClickListener { handleButtonClick('V') }
        WButton.setOnClickListener { handleButtonClick('W') }
        XButton.setOnClickListener { handleButtonClick('X') }
        YButton.setOnClickListener { handleButtonClick('Y') }
        ZButton.setOnClickListener { handleButtonClick('Z') }

        buttonRow1.add(findViewById(R.id.button1row1))
        buttonRow1.add(findViewById(R.id.button2row1))
        buttonRow1.add(findViewById(R.id.button3row1))
        buttonRow1.add(findViewById(R.id.button4row1))
        buttonRow1.add(findViewById(R.id.button5row1))

        buttonRow2.add(findViewById(R.id.button1row2))
        buttonRow2.add(findViewById(R.id.button2row2))
        buttonRow2.add(findViewById(R.id.button3row2))
        buttonRow2.add(findViewById(R.id.button4row2))
        buttonRow2.add(findViewById(R.id.button5row2))

        buttonRow3.add(findViewById(R.id.button1row3))
        buttonRow3.add(findViewById(R.id.button2row3))
        buttonRow3.add(findViewById(R.id.button3row3))
        buttonRow3.add(findViewById(R.id.button4row3))
        buttonRow3.add(findViewById(R.id.button5row3))

        buttonRow4.add(findViewById(R.id.button1row4))
        buttonRow4.add(findViewById(R.id.button2row4))
        buttonRow4.add(findViewById(R.id.button3row4))
        buttonRow4.add(findViewById(R.id.button4row4))
        buttonRow4.add(findViewById(R.id.button5row4))

        buttonRow5.add(findViewById(R.id.button1row5))
        buttonRow5.add(findViewById(R.id.button2row5))
        buttonRow5.add(findViewById(R.id.button3row5))
        buttonRow5.add(findViewById(R.id.button4row5))
        buttonRow5.add(findViewById(R.id.button5row5))

        buttonRows = arrayListOf(buttonRow1,buttonRow2,buttonRow3,buttonRow4,buttonRow5)

        warningTextView = findViewById(R.id.warningTextView)
        skorTextView = findViewById(R.id.skorTextView)
        handleResetClick()
        word = list_words.asSequence().shuffled().find { true }.toString()
        Log.d("Answer",word)

    }



}