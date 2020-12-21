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
import kr.co.everex.mycustommaterialcalender.databinding.FragmentBlankTwoBinding


class BlankTwoFragment : Fragment() {
    private var _binding: FragmentBlankTwoBinding? = null
    private val binding get() = _binding!! // 해당 속성은 onCreateView 와 onDestroyView 에서만 유효함


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlankTwoBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }




}