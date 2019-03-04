package com.songdehuai.myrefreshtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.songdehuai.widget.myrefreshlayout.MyRefreshLayout
import com.songdehuai.widget.myrefreshlayout.RefreshListenerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val testAdapter = TestAdapter(this)
        main_lv.adapter = testAdapter
        main_rf.setBottomView(MyLoadingView(this))
        main_rf.setOnRefreshListener(object : RefreshListenerAdapter() {
            override fun onRefresh(refreshLayout: MyRefreshLayout?) {
                super.onRefresh(refreshLayout)
                testAdapter.setData()
            }

            override fun onLoadMore(refreshLayout: MyRefreshLayout?) {
                super.onLoadMore(refreshLayout)
                testAdapter.addData(10)
            }
        })
        testAdapter.setOnLoadMoreListener {
            main_rf.finish()
        }
    }
}
