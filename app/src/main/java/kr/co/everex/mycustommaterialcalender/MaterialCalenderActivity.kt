package kr.co.everex.mycustommaterialcalender

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.Pair
import com.google.android.material.datepicker.MaterialDatePicker
import kr.co.everex.mycustommaterialcalender.databinding.ActivityMaterialCalenderBinding

class MaterialCalenderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMaterialCalenderBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialCalenderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료

        // 날짜 선택
        val materialDateBuilder: MaterialDatePicker.Builder<*> = MaterialDatePicker.Builder.datePicker()
        materialDateBuilder.setTitleText("날짜 선택하기")
        val materialDatePicker = materialDateBuilder.build();

        // 기간 선택
        val materialRangeBuilder: MaterialDatePicker.Builder<Pair<Long, Long>> = MaterialDatePicker.Builder.dateRangePicker()
        val materialRangePicker = materialRangeBuilder.build();


        binding.pickDateButton.setOnClickListener{
            materialDatePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER")
        }

        materialDatePicker.addOnPositiveButtonClickListener {
            binding.showSelectedDate.text = "Selected Date is : " + materialDatePicker.headerText
        }


        binding.pickDateButton2.setOnClickListener{
            materialRangePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER");
        }
        materialRangePicker.addOnPositiveButtonClickListener {
            binding.showSelectedDate2.text = "Selected Date How long is : " + materialRangePicker.headerText
        }

    }



}