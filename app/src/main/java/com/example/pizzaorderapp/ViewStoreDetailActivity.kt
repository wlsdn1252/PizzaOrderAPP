package com.example.pizzaorderapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.pizzaorderapp.datas.Store
import kotlinx.android.synthetic.main.activity_view_store_detail.*

// 가게 상세보기 액티비티
class ViewStoreDetailActivity : BaseActivity() {

        lateinit var mStoreData : Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()

    }
    // 동작 관련 함수
    override fun setupEvents() {

        callPhoneBtn.setOnClickListener {
            val myUri = Uri.parse("tel:${mStoreData.phoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL,myUri)
            startActivity(myIntent)
        }

    }

        // 화면 관련 함수
    override fun setValues() {

            mStoreData = intent.getSerializableExtra("storeData") as Store

            Glide.with(mContext).load(mStoreData.logoURL).into(storeLogoImg)
            storePhoneNumTxt.text = mStoreData.phoneNum
            storeNameTxt.text = mStoreData.name

    }


}