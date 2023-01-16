package com.example.pizzaorderapp.datas

import java.io.Serializable

class Store(
        val name : String,
        val phoneNum : String,
        val logoURL : String) : Serializable { //PizzaStoreListFragment 에서 puExtra로 데이터를 넘길때 에러없이 넘기기 위해 Serializable을 적어준다.
}