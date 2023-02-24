package com.transcendence.freeland.main

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.transcendence.core.base.activity.BaseAc
import com.transcendence.core.base.route.RoutePath
import com.transcendence.core.utils.statusbar.NativeStatusBarUtils
import com.transcendence.freeland.R
import java.util.*

/**
 * @author: 杨充
 * @email  : yangchong211@163.com
 * @time   : 2022/04/28
 * @desc   : apm小工具，模拟滑动卡顿
 * @revise :
 */
@Route(path = RoutePath.Demo.PAGER_BLOCK_LIST)
class BlockListActivity : BaseAc() {

    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: MyAdapter? = null
    private val mListData = ArrayList<Int>()

    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_block_list)
//        NativeStatusBarUtils.with(this).init()
        mRecyclerView = findViewById(R.id.rv)
        for (i in 0..99) {
            mListData.add(i)
        }
        mRecyclerView?.layoutManager = LinearLayoutManager(this)
        mAdapter = MyAdapter()
        mRecyclerView?.adapter = mAdapter

        //模拟滑动卡顿的情况
        mRecyclerView?.setOnScrollChangeListener(View.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (Math.random() < 0.01) {
                try {
                    Thread.sleep(2600)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        })
    }

    companion object {
        fun launch(context: Context){
            val intent = Intent(context,BlockListActivity::class.java);
            context.startActivity(intent);
        }
    }


    internal inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView
        fun setData(position: Int) {
            textView.text = mListData[position].toString()
        }

        init {
            textView = itemView.findViewById(R.id.tv_block_list)
        }
    }

    internal inner class MyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
            val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.activity_block_list_item_block_scrolling, viewGroup, false)
            return MyHolder(v)
        }

        override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
            (viewHolder as MyHolder).setData(i)
        }

        override fun getItemCount(): Int {
            return mListData.size
        }
    }
}