package com.ishanvi.myfirstapplication

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var btnBluetooth: ImageButton
//    lateinit var itemAdaptor: ItemAdaptor
//    lateinit var recyclerView: RecyclerView
//    lateinit var mList:ArrayList<String>
//    private lateinit var dialog: BottomSheetDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        btnBluetooth=view.findViewById(R.id.btnBluetooth)
        var count=0

//        for (i in 1..10){
//            mList.add("Bluetooth Device $i")
//        }

        val bottomSheetFragment=BottomSheetFragment()
        btnBluetooth.setOnClickListener {
            if(count==0){
                btnBluetooth.setBackgroundResource(R.drawable.round_btn_green)
                count=1
                bottomSheetFragment.show(requireActivity().supportFragmentManager,"BottomSheetFragment")




            }
            else{
                btnBluetooth.setBackgroundResource(R.drawable.round_btn)
                count=0

            }




        }



        return view
    }
//    private fun showBottomSheet(){
//        val dialogView= layoutInflater.inflate(R.layout.bottom_sheet,null)
//        dialog=BottomSheetDialog(requireContext(),R.style.BottomSheetDialogTheme)
//        dialog.setContentView(dialogView)
//        recyclerView=dialogView.findViewById(R.id.rvItem)
//        itemAdaptor= ItemAdaptor(requireContext(),mList)
//        recyclerView.adapter=itemAdaptor
//        dialog.show()
//
//
//        }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}