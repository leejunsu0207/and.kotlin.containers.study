package com.ljs.and.containerspinner

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.ljs.and.containerspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var data = listOf("- 선택하세요 -", "1월", "2월", "3월", "4월", "5월", "6월")
        var adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, data)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
               binding.result.text = data.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val data1:MutableList<Memo> = loadData()
        var adapter1 = CustomAdapter()
        adapter1.listData = data1
        binding.recyclerView.adapter = adapter1
        binding.recyclerView.layoutManager = LinearLayoutManager(this)




    }

    fun loadData():MutableList<Memo>{
        val data: MutableList<Memo> = mutableListOf()
        for(no in 1..100){
            val title = "이것이 안드로이드 ${no}"
            val date = System.currentTimeMillis()
            var memo = Memo(no, title, date)
            data.add(memo)
        }
        return data
    }



}