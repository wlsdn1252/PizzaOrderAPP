package com.example.pizzaorderapp

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    // 어떤 화면에 뿌려줄건지 미리 변수에 대입해준다.
    val mContext = this

    // 이벤트 처리를 위한 기능을 모아두는 추상 함수
    abstract fun setupEvents()

    // 화면에 뿌려주는 기능을 모아둔 추상 함수
    abstract fun setValues()

}