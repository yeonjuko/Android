package com.example.ex221124

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

// : Kotlin에서 상속
class ConstraintActivity : AppCompatActivity() {
    // OnCreate()는 Activity가 실행될때 최초 딱 한번(가장 먼저) 호출되는 메서드
    // : Activity 생명주기
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ***** xml이랑 KotlinClass랑 연결하는 코드. 없으면 화면 안뜸! *****

        setContentView(R.layout.activity_constraint)

        // 1. xml의 View에 id를 지정
        // 2. id값을 이용해서 view를 찾아온다 (findViewById)
        // R.id.tvResult = 리소스.id.tvResult
//        val tvResult: TextView = findViewById<TextView>(R.id.tvResult)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        // id값은 문자열로 정해줬는데 받아오는 값이 Int
        // R 폴더에 모든 뷰(리소스)들의 id값이 저장되는데 주소값이 저장
        // 16진수 상수형태로 저장이 되어있다 (Int)

        // ** setContentView 위로 find할 수 없다!! **
        tvResult.setTextColor(Color.BLUE)
        tvResult.setTextColor(Color.parseColor("#ff9999"))
        // textSize에는 Float자료형이 들어가야 한다! (f : 형변환)
        tvResult.textSize = 40.0f
        tvResult.text = "안녕하세요!"
        // charSequence 인터페이스 - String은 CharSequence 인터페이스를 상속받는 중

        // 더하기 버튼을 눌렀을 때 "더하기 버튼이 눌렸습니다"라는 Toast를 띄우기!
        // 이벤트를 주는 방법
        // 1) 이벤트 메소드 설계 후 뷰에 연결하기
        // 2) innerClass (Listener OnClick 구현)
        btnMinus.setOnClickListener {
            // {}안에다가 기능 구현만 하면 됨! 람다식을 사용한 방법
            // 버튼을 눌렀을 때 "마이너스 버튼이 눌렸습니다" 토스트 띄우기
            Toast.makeText(this, "마이너스 버튼이 눌렸습니다",Toast.LENGTH_SHORT).show()
        }
        // 3) interfacef를 상속받게 만들어서 OnClick 구현
    } // onCreate 밖

    // 1번 방법
    // 이벤트 리스너는 무조건 View 매개변수를 가지고 있어야 한다.
    fun myClick(view: View){
        // Toast 띄우기!
        // 1) this : ConstraintActivity.this : Toast를 띄울 화면 정보
        // 2) 문구 (무조건 String, Int가 허용되는 경우는 id값만)
        // 3) Toast에 Short(3초), Long(5초) 속성 사용 : 지속시간
        Toast.makeText(this,"더하기 버튼이 눌렸습니다",Toast.LENGTH_SHORT).show()
    }
}