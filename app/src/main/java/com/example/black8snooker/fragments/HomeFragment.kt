package com.example.black8snooker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.black8snooker.R
import com.example.black8snooker.adapters.DashboardAdapter
import com.example.black8snooker.databinding.FragmentHomeBinding
import com.example.black8snooker.model.Dashboard

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    /*binding = DataBindingUtil.s*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val dashboard = mutableListOf<Dashboard>()
        dashboard.add(Dashboard("Chat", R.drawable.chat))
        dashboard.add(Dashboard("Live", R.drawable.live))
        dashboard.add(Dashboard("Youtube",R.drawable.youtube))
        dashboard.add(Dashboard("Follow us",R.drawable.facebook))
        /*songObject.add(Dashboard("Promotion", "sheikh"))*/

        binding.dashboardRecyclerView.adapter = DashboardAdapter(dashboard as ArrayList<Dashboard>,requireActivity())
        binding.dashboardRecyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        return binding.root
    }

}