package kr.co.everex.mycustommaterialcalender

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.co.everex.mycustommaterialcalender.databinding.ActivityMainBinding
import kr.co.everex.mycustommaterialcalender.databinding.ActivityTimeCalculateBinding
import java.text.SimpleDateFormat
import java.util.*

class TimeCalculateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTimeCalculateBinding

    // 전체 총 합 시간
    var totalTime = "00:00:00"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimeCalculateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료

        /**
         * 1. 이전에 전체 합해져 있던 시간("00:00:00")을 Millis 환산
         * 2. 더 해야 할 시간("00:00")을 Millis 환산
         * 3. 1+2 시간을 합친다. [Millis]
         * 4. 3번의 다 합쳐진 Millis 를 "00:00:00" 형태로 변환하여, 결과 표현
         *
         */
        binding.btnAdd.setOnClickListener(){
            // 1. 전체 총 합 시간 Millis
            val totalTimeMillis = threeSplitTimeToMillisecond(totalTime)
            // 2. 더 해야할 시간 Millis
            val addTimeMillis = textToMillisecond(binding.EdtData.text.toString())

            // 3. 토탈 시간 환산하고 + 더해야 할 시간 을 합친다 [Millis]
            val valueToAdd = totalTimeMillis + addTimeMillis
            // 4. 합친 시간을 전역변수에 재 할당 "00:00:00" 형태
            totalTime = updateCountDownText(valueToAdd)

            // 합산 결과 표현
            binding.textViewTotalTime.text = totalTime
        }
    }

    /**
     * 밀리세컨드 변환기능 함수
     * 10:30 같이 표기된 시간을 -> 밀리세컨드로 변환
     * @param {String} stringTime => 10:30 같이 표기된 시간
     * @return {Long} => 변환된 Millisecond 반환
     */
    fun textToMillisecond(stringTime: String) : Long {
        val token = stringTime.split(':') // 데이터 분,초 분리
        // 분리 후 환산되어야 하는 초
        println(token[0]) // 10(분) = 600000ms, 1(분) = 60000ms
        println(token[1]) // 30(초) =  30000ms

        // 1. 분 -> Millisecond
        val minuteMillisecond = token[0].toLong() * 60000
        // 2. 초 -> Millisecond
        val secondMillisecond = token[1].toLong() * 1000
        // 시간 To Millisecond 환산 통합
        val totalTime = minuteMillisecond + secondMillisecond

        return totalTime
    }

    /**
     * 밀리세컨드 변환기능
     * 01:10:30 같이 표기된 시간을 -> 밀리세컨드로 변환
     * @param {String} stringTime => 01:10:30 같이 표기된 시간
     * @return {Long} => 변환된 Millisecond 반환
     */
    fun threeSplitTimeToMillisecond(stringTime: String) : Long {
        val token = stringTime.split(':') // 데이터 분,초 분리

        // 1. 시 -> Millisecond
        val hourMillisecond = token[0].toLong() * 3600000
        // 2. 분 -> Millisecond
        val minuteMillisecond = token[1].toLong() * 60000
        // 3. 초 -> Millisecond
        val secondMillisecond = token[2].toLong() * 1000
        // 시간 To Millisecond 환산 통합
        val totalTime = hourMillisecond + minuteMillisecond + secondMillisecond

        return totalTime
    }

    /**
     * 밀리세컨드 데이터를 00:00:00 형태로 변경
     */
    private fun updateCountDownText(timeLeftInMillis : Long) : String {
        val hours = (timeLeftInMillis / 1000).toInt() / 3600
        val minutes = ((timeLeftInMillis / 1000).toInt() / 60) - (60*hours)
        val seconds = (timeLeftInMillis / 1000).toInt() % 60
        val timeLeftFormatted: String =
            java.lang.String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds)

        return timeLeftFormatted
    }

}