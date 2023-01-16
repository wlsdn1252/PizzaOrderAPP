package com.example.pizzaorderapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.ViewStoreDetailActivity
import com.example.pizzaorderapp.adapters.PizzaStoreAdapter
import com.example.pizzaorderapp.datas.Store
import kotlinx.android.synthetic.main.fragment_pizza_store_list.*

class PizzaStoreListFragment : Fragment() {

    // ArrayList에 Store를 담아서 멤버 변수로 담아준다.
    val mPizzaStoreDataList = ArrayList<Store>()

    lateinit var mPizzaStoreAdapter : PizzaStoreAdapter

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

        mPizzaStoreDataList.add(Store("A피자가게","1111-5555","https://cdn3.iconfinder.com/data/icons/street-food-and-food-trucker-1/64/pizza-fast-food-bake-bread-128.png"))
        mPizzaStoreDataList.add(Store("B피자가게","1111-1255","https://cdn1.iconfinder.com/data/icons/cartoon-snack/128/pizza-128.png"))
        mPizzaStoreDataList.add(Store("C피자가게","1111-5435","https://cdn3.iconfinder.com/data/icons/food-set-3/91/Food_C219-128.png"))
        mPizzaStoreDataList.add(Store("D피자가게","1111-5565","https://cdn0.iconfinder.com/data/icons/fastfood-31/64/pizza-italian-food-fast-fastfood-cheese-piece-128.png"))

        mPizzaStoreAdapter = PizzaStoreAdapter(requireContext(),R.layout.pizza_store_list_item,mPizzaStoreDataList)

        // 리스트뷰에 실제 화면 연결
        pizzaStoreListView.adapter = mPizzaStoreAdapter

        // 리스트의 한줄이 클릭되면
        pizzaStoreListView.setOnItemClickListener { parent, view, position, id ->

            // 클릭된 리스트의 한 줄에 해당하는 position을 담아준다.
            val clickedStore = mPizzaStoreDataList[position]

            // 클릭된 한 줄의 데이터를 통째로 들고 해당 액티비티로 이동
            val myIntent = Intent(requireContext(), ViewStoreDetailActivity :: class.java)

            //Store에서 Serializable을 해줘야 에러없이 작동한다.
            myIntent.putExtra("storeData",clickedStore)
            startActivity(myIntent)

        }
    }
}