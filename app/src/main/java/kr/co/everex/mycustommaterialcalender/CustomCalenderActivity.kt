package kr.co.everex.mycustommaterialcalender

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import kr.co.everex.mycustommaterialcalender.databinding.ActivityCustomCalenderBinding


class CustomCalenderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomCalenderBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomCalenderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료




    }


}