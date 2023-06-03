package com.ishanvi.myfirstapplication


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment: BottomSheetDialogFragment(){
    lateinit var recyclerHome: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerAdapter: ItemAdaptor
    val list= arrayListOf("1","2","3","4","5","6","7","8","9","10")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.bottom_sheet,container,false)
        recyclerHome=view.findViewById(R.id.recyclerHome)
        layoutManager= LinearLayoutManager(activity)
        recyclerAdapter= ItemAdaptor(activity as Context,list)
        recyclerHome.adapter=recyclerAdapter
        recyclerHome.layoutManager=layoutManager
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}