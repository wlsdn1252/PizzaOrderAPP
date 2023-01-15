package com.example.pizzaorderapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pizzaorderapp.fragments.ChickenStoreListFragment
import com.example.pizzaorderapp.fragments.PizzaStoreListFragment

class MainViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    // 텝레이아웃의 제목을 적는 함수
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "피자가게"
            else -> "치킨가게"
        }

    }

    
    // 각각의 position에 맞는 Fragment가 어떤 Fragment인지 명시해주는 함수
    override fun getItem(position: Int): Fragment {

        return when (position){
            0 -> PizzaStoreListFragment()
            else -> ChickenStoreListFragment()
        }

    }

    // 뷰페이저가 총 몇페이지를 표현하고싶은지 숫자로 리턴
    override fun getCount(): Int {
        return 2
    }



}