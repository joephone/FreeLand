package com.transcendence.freeland.ui.rv.vp.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.transcendence.freeland.R
import com.transcendence.freeland.ui.rv.vp.adapter.RcAdapter

private const val ARG_PARAM1 = "param1"

/**
 * Fragment
 */
class TestFragment : Fragment() {
    private var param1: String? = null
    lateinit var inflate: View
    lateinit var activity: Activity
    lateinit var rv: RecyclerView


    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as Activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflate = inflater.inflate(R.layout.activity_ui_rv_vp_fragment, container, false)
        rv = inflate.findViewById(R.id.rv)
        initView()
        initData()
        return inflate
    }

    private fun initView() {
        //recyclerView layoutManager
        rv.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rv.adapter = RcAdapter(activity)
    }

    private fun initData() {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            TestFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}