package com.ishanvi.myfirstapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdaptor(val context: Context,val itemList:ArrayList<String>): RecyclerView.Adapter<ItemAdaptor.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_home_row,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val text =itemList[position]
        holder.textView.text=text
        holder.textView2.text=text





    }
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textView :TextView=view.findViewById(R.id.txtRecyclerRowItem)
        val textView2 :TextView=view.findViewById(R.id.txtMAC)


    }


}