package com.example.t3_221116955

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ScoreActivity : AppCompatActivity() {
    private var skor:Int = 0
    private lateinit var skorTextView: TextView

    private lateinit var namaEditTextView: TextView
    private lateinit var telpEditTextView: TextView
    private lateinit var sendBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        skor = intent.getIntExtra("skor", 0)
        skorTextView = findViewById(R.id.skor)
        skorTextView.setText("Skor : "+skor.toString())
        namaEditTextView = findViewById(R.id.namaEditText)
        telpEditTextView = findViewById(R.id.telpEditText)
        sendBtn = findViewById(R.id.sendBtn)

        sendBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:${telpEditTextView.text}")
                putExtra("sms_body", "Wah aku mendapatkan skor ${skor.toString()} pada game Wordle! Berapa skormu?")
            }
            startActivity(intent)
        }

    }
}