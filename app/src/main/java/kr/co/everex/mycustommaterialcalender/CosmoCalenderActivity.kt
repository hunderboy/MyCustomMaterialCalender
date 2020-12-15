package kr.co.everex.mycustommaterialcalender



import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioGroup
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.OrientationHelper
import com.applikeysolutions.cosmocalendar.utils.SelectionType
import com.applikeysolutions.cosmocalendar.view.CalendarView
import kr.co.everex.mycustommaterialcalender.databinding.ActivityCosmoCalenderBinding
import java.text.SimpleDateFormat
import java.util.*


class CosmoCalenderActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {
    private lateinit var binding: ActivityCosmoCalenderBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCosmoCalenderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료


        binding.calendarView.calendarOrientation = OrientationHelper.HORIZONTAL
        binding.rgSelectionType.setOnCheckedChangeListener(this)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {


            R.id.clear_selections -> {
                clearSelectionsMenuClick()
                true
            }
            R.id.show_selections -> {
                val days: List<Calendar> = binding.calendarView.getSelectedDates()
                var result = ""
                var i = 0
                while (i < days.size) {
                    val calendar: Calendar = days[i]
                    val day: Int = calendar.get(Calendar.DAY_OF_MONTH)
                    val month: Int = calendar.get(Calendar.MONTH)
                    val year: Int = calendar.get(Calendar.YEAR)
                    val week: String = SimpleDateFormat("EE").format(calendar.getTime())
                    val day_full =
                        year.toString() + "년 " + (month + 1) + "월 " + day + "일 " + week + "요일"
                    result += """
                      $day_full
                      
                      """.trimIndent()
                    i++
                }
                Toast.makeText(this@CosmoCalenderActivity, result, Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun clearSelectionsMenuClick() {
        binding.calendarView.clearSelections()
    }


    override fun onCheckedChanged(group: RadioGroup?, @IdRes checkedId: Int) {
        clearSelectionsMenuClick()
        when (checkedId) {
            binding.rbSingle.id -> binding.calendarView.selectionType = SelectionType.SINGLE
            binding.rbMultiple.id -> binding.calendarView.selectionType = SelectionType.MULTIPLE
            binding.rbRange.id -> binding.calendarView.selectionType = SelectionType.RANGE
            binding.rbNone.id -> binding.calendarView.selectionType = SelectionType.NONE
        }
    }


}

