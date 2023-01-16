package com.example.pizzaorderapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.adapters.ChickenStoreAdapter
import com.example.pizzaorderapp.adapters.PizzaStoreAdapter
import com.example.pizzaorderapp.datas.Store
import kotlinx.android.synthetic.main.fragment_chicken_store_list.*

class ChickenStoreListFragment : Fragment() {

    // Store클래스를 ArrayList에 담아서 변수에 담아준다.
    val mChickenStoreDataList = ArrayList<Store>()

    // 치킨어댑터를 좀 이따 담아주겠다.
    lateinit var mChickenStoreAdapter : ChickenStoreAdapter

    // fragment_pizza_store_list.xml이랑 연결 시키기
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chicken_store_list, container,false)
    }

    // 동작에 관련된 코드
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mChickenStoreDataList.add(Store("처갓집 양념치킨","1111-2222","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCkh-qj9p48r_iBg9gy8_DT-mQvsZVkpRZoA&usqp=CAU"))
        mChickenStoreDataList.add(Store("네네치킨","1111-2222","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTptfTtQEMW85GKAHtb2AaooBiBZ4E5xUNm3Q&usqp=CAU"))
        mChickenStoreDataList.add(Store("교촌치킨","1111-2222","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUsjIkeaH0SrpLokQsUjY4L1xjm5IorwnUSg&usqp=CAU"))
        mChickenStoreDataList.add(Store("굽네치킨","1111-2222","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRo0QNfIkTdWpdP5Jemk_VKGZAAHlQKK9asfQ&usqp=CAU"))

        // lateinit var로 설정한 변수를 지금 대입해준다.
        // 어댑터 연결                               어느화면에서                 무슨화면을                어떤방식으로
        mChickenStoreAdapter = ChickenStoreAdapter(requireContext(),R.layout.chicken_store_list_item,mChickenStoreDataList)

        // 화면에 나타나게 해줌
        chickenListView.adapter = mChickenStoreAdapter
    }
}