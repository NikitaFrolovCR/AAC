package com.example.nikita.aac

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.nikita.aac.base.BaseLifecycleActivity
import com.example.nikita.aac.network.bean.UserBean

class MainActivity : BaseLifecycleActivity<UserViewModel>() {
    override val viewModelClass = UserViewModel::class.java
    private lateinit var tvTitle: TextView
    private lateinit var tvUrl: TextView
    private lateinit var bLoad: Button
    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTitle = findViewById(R.id.tvTitle)
        tvTitle.text = "1"
        tvUrl = findViewById(R.id.tvUrl)
        bLoad = findViewById(R.id.bLoad)
        progress = findViewById(R.id.progress)
        bLoad.setOnClickListener {
            viewModel.loadUser(tvTitle.text.toString().toLong())

        }
        observeLiveData()

    }

    private fun showProgress(isShow: Boolean) {
        progress.visibility = if (isShow) View.VISIBLE else View.GONE
    }

    private fun loadData(bean: UserBean) {
        tvUrl.text = bean.url
    }

    private fun observeLiveData() {
        viewModel.isLoadingLiveData.observe(this, Observer<Boolean> {
            it?.let { showProgress(it) }
        })
        viewModel.userLiveData.observe(this, Observer<Pair<UserBean?, Throwable?>> {
            it?.first?.let { loadData(it) }
            it?.second?.message?.let { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
        })

    }
}