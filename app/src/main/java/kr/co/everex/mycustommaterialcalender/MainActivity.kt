package kr.co.everex.mycustommaterialcalender

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.everex.mycustommaterialcalender.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료

        binding.button.setOnClickListener(){
            val intent = Intent(this, CustomCalenderActivity::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener(){
            val intent = Intent(this, MaterialCalenderActivity::class.java)
            startActivity(intent)
        }

        binding.button3.setOnClickListener(){
            val intent = Intent(this, CosmoCalenderActivity::class.java)
            startActivity(intent)
        }

    }






}