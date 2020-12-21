package kr.co.everex.mycustommaterialcalender

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kr.co.everex.mycustommaterialcalender.databinding.ActivityMainBinding
import kr.co.everex.mycustommaterialcalender.databinding.ActivityMaterialInFragmentBinding
import kr.co.everex.mycustommaterialcalender.fragment.BlankOneFragment
import kr.co.everex.mycustommaterialcalender.fragment.BlankTwoFragment

class MaterialInFragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMaterialInFragmentBinding


    // 뷰 페이저 프래그먼트
    // Todo Select로 시작하는 파일은 필요없다.
    private val blankOneFragment = BlankOneFragment()
    private val blankTwoFragment = BlankTwoFragment()

    private val pagerAdapter = ScreenSlidePagerAdapter(this)

    // 프래그먼트 리스트 설정
    val bodyInformationFragmentList = mutableListOf<Fragment>(
            blankOneFragment,
//            blankTwoFragment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialInFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.viewpager2.adapter = pagerAdapter
    }


    // 어댑터
    inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return bodyInformationFragmentList.size
        }
        override fun createFragment(position: Int): Fragment {
            return bodyInformationFragmentList[position]
        }
    }

    private fun getCurrentItemPosition(i: Int): Int {
        return binding.viewpager2.currentItem + i
    }


}