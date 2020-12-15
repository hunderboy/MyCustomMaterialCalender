package kr.co.everex.mycustommaterialcalender

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.CalendarView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kr.co.everex.mycustommaterialcalender.databinding.ActivityCustomCalenderBinding
import java.util.*


class CustomCalenderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomCalenderBinding

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomCalenderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료


//        binding.button.setOnClickListener(){
//            val today = GregorianCalendar()
//            val year: Int = today.get(Calendar.YEAR)
//            val month: Int = today.get(Calendar.MONTH)
//            val date: Int = today.get(Calendar.DATE)
//
//            val dlg = DatePickerDialog(this,
//                { view, year, month, dayOfMonth ->
//                    binding.textView.text = "${year}년 ${month + 1}월 ${dayOfMonth}일"
//                }, year, month, date
//            )
//            dlg.show()
//        }


        binding.calendarView.setOnDateChangeListener(object : CalendarView.OnDateChangeListener {
            override fun onSelectedDayChange(
                view: CalendarView,
                year: Int,
                month: Int,
                dayOfMonth: Int
            ) {
                val date = year.toString() + "/" + (month + 1) + "/" + dayOfMonth
                Toast.makeText(applicationContext, "선택된 날짜 = $date", Toast.LENGTH_SHORT).show()
                binding.textView2.text = "선택된 날짜 = $date"

            }
        })


//        binding.calendarView.setOnDateChangeListener(CalendarView.OnDateChangeListener(){
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
//            {
//                String date = year + "/" + (month + 1) + "/" + dayOfMonth;
//                whenDate.setText(date); // 선택한 날짜로 설정
//
//            }
//        })



    }


}