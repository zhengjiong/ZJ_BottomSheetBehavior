package com.zj.widget.bottomsheetbehavior

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val scrollView = findViewById<View>(R.id.scrollView)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        val behavior = CustomBottomSheetBehavior2.from(scrollView)
        behavior.state = CustomBottomSheetBehavior2.STATE_HALF
        behavior.setBottomSheetCallback(object : CustomBottomSheetBehavior2.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == CustomBottomSheetBehavior2.STATE_COLLAPSED) {
                    //Toast.makeText(this@MainActivity, "折叠了", Toast.LENGTH_SHORT).show()
                } else if (newState == CustomBottomSheetBehavior2.STATE_EXPANDED) {
                    //Toast.makeText(this@MainActivity, "展开了", Toast.LENGTH_SHORT).show()
                } else if (newState == CustomBottomSheetBehavior2.STATE_HIDDEN) {
                    //Toast.makeText(this@MainActivity, "隐藏了", Toast.LENGTH_SHORT).show()
                } else if (newState == CustomBottomSheetBehavior2.STATE_HALF) {
                    //Toast.makeText(this@MainActivity, "HALF", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                println("slideOffset = ${slideOffset}")
                if (slideOffset >= 1) {
                    toolbar.title = "百果园-天鹅湖店"
                } else {
                    toolbar.title = ""
                }
            }

        })


        val recyclerView1 = findViewById<RecyclerView>(R.id.recyclerview1)
        val recyclerView2 = findViewById<RecyclerView>(R.id.recyclerview2)
        recyclerView1.layoutManager = LinearLayoutManager(this)
        recyclerView1.adapter = Adapter(this)


        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.adapter = Adapter(this)

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
