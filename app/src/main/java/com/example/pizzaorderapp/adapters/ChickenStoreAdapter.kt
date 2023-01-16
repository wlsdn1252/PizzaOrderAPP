package com.example.pizzaorderapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.datas.Store


class ChickenStoreAdapter (val mContext : Context, val resId : Int, val mList: List<Store>): ArrayAdapter<Store>(mContext,resId,mList) {

    // xml을 가지고 객체로 변환해주는(화면에 뿌리도록 도와주는) 변수를 멤버변수로 생성
    val inflater = LayoutInflater.from(mContext)

    // 기본모양이 아닌 우리가 원하는 모양으로 뿌리려고 하는 오버라이딩
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inflater.inflate(R.layout.chicken_store_list_item, null)
        }
        val row = tempRow!!

        // 리스트 한 줄에 데이터 대입
        val data = mList[position]

        // 한 행의 아이디를 찾는데 텍스트뷰 형식의 id가 storeNameTxt인것을 대입하라.
        val nameTxt = row.findViewById<TextView>(R.id.storeNameTxt)
        val logoImage = row.findViewById<ImageView>(R.id.logoImg)

        // xml파일에서 id를 대입한 변수에 실제 데이터를 넣어준다.
        nameTxt.text = data.name
        
        // Glide 라이브러리 활용 해당 이미지를 대입
        Glide.with(mContext).load(data.logoURL).into(logoImage)



        return row
    }
}