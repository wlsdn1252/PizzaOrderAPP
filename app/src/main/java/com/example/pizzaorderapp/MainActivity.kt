package com.example.pizzaorderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pizzaorderapp.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    
    // 만든 프래그먼트와 뷰페이저를 연결시켜 화면에 구현시키기
    lateinit var mvpa : MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
    }

    // BaseActivity에서 선언한 함수들을 재사용하기위해 오버라이딩
    // 버튼 크릭등의 이벤트 관련 코드 모음
    override fun setupEvents() {

    }

    // BaseActivity에서 선언한 함수들을 재사용하기위해 오버라이딩
    // 화면에 데이터를 표시하기 위한 코드 모음
    override fun setValues() {

        // 뷰페이저 작업
        // 화면에 프래그먼트가 나옴
        mvpa = MainViewPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mvpa

        // 탭레이아웃과 뷰페이저 연결
        mainTabLayout.setupWithViewPager(mainViewPager)
    }


}