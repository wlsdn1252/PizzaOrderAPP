package com.example.pizzaorderapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzaorderapp.R

class PizzaStoreListFragment : Fragment() {

    // fragment_pizza_store_list.xml이랑 연결 시키기
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pizza_store_list, container,false)
    }

    // 동작에 관련된 코드
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}