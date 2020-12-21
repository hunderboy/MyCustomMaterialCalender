package kr.co.everex.mycustommaterialcalender.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.Pair
import com.google.android.material.datepicker.MaterialDatePicker
import kr.co.everex.mycustommaterialcalender.R
import kr.co.everex.mycustommaterialcalender.databinding.FragmentBlankOneBinding


class BlankOneFragment : Fragment() {
    private var _binding: FragmentBlankOneBinding? = null
    private val binding get() = _binding!! // 해당 속성은 onCreateView 와 onDestroyView 에서만 유효함


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlankOneBinding.inflate(inflater, container, false)
        val view = binding.root




        // 기간 선택
        val materialRangeBuilder: MaterialDatePicker.Builder<Pair<Long, Long>> = MaterialDatePicker.Builder.dateRangePicker()
//        materialRangeBuilder.setTitleText("기간 선택하기")
        materialRangeBuilder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar)
        val materialRangePicker = materialRangeBuilder.build()


        binding.button.setOnClickListener{
            materialRangePicker.show(fragmentManager!!, "MATERIAL_DATE_PICKER")
//            (activity as InputBodyInformationToJoinActivity).showRangeCalendar()
        }

        return view
    }





}