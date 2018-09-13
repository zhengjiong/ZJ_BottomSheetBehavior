package com.zj.widget.bottomsheetbehavior

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 *
 * Company: 上加下信息技术成都有限公司
 * CreateTime:2018/9/13  08:45
 * @author 郑炯
 * @version 1.0
 */

class TestFragment : Fragment() {
    lateinit var recyclerView1: RecyclerView
    lateinit var recyclerView2: RecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView1 = view!!.findViewById<RecyclerView>(R.id.recyclerview1)
        recyclerView2 = view.findViewById<RecyclerView>(R.id.recyclerview2)

        recyclerView1.layoutManager = LinearLayoutManager(context)
        recyclerView1.adapter = Adapter(context)


        recyclerView2.layoutManager = LinearLayoutManager(context)
        recyclerView2.adapter = Adapter(context)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView

        init {
            this.title = itemView.findViewById(android.R.id.text1)
        }
    }

    class Adapter(val context: Context) : RecyclerView.Adapter<MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return 30
        }

        override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
            holder!!.title.setText("item-${position}")
        }
    }


}