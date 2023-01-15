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

// Store.class를 뿌려주는 어댑터를 만들거다
//                          뿌려줄 화면,        어떤 모양을 그릴지,     어떤 목록을 뿌릴지
class PizzaStoreAdapter(val mContext: Context, val resId : Int, val mList: List<Store>) : ArrayAdapter<Store>(mContext,resId,mList) {
    // xml을 가지고 객체로 변환해주는(화면에 뿌리도록 도와주는) 변수를 멤버변수로 생성
    val inflater = LayoutInflater.from(mContext)

    // 기본모양이 아닌 우리가 원하는 모양으로 뿌리려고 하는 오버라이딩
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null){
            tempRow = inflater.inflate(R.layout.pizza_store_list_item,null)
        }

        val row = tempRow!!

        // 리스트뷰 한줄에 실제 데이터를 대입
        val data = mList[position]
        val storeNameTxt = row.findViewById<TextView>(R.id.storeNameTxt)
        val logoImg = row.findViewById<ImageView>(R.id.logoImg)

        storeNameTxt.text = data.name
        Glide.with(mContext).load(data.logoURL).into(logoImg)
        return row

    }

}