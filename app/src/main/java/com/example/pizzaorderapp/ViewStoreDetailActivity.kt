package com.example.pizzaorderapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.pizzaorderapp.datas.Store
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
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

            // 전화걸기위한 권한 설정
            val permissionListener = object  : PermissionListener{

                // 권한 허락시
                override fun onPermissionGranted() {
                    val myUri = Uri.parse("tel:${mStoreData.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL,myUri)
                    startActivity(myIntent)
                }

                // 권한 거부
                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "권한이 거부되었습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.create()
                .setPermissionListener(permissionListener)
                .setDeniedMessage("설정에서 권할을 켜주세요")
                .setPermissions(android.Manifest.permission.CALL_PHONE)
                .check()

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