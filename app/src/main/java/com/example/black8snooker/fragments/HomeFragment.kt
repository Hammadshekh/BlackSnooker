package com.example.black8snooker.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.black8snooker.R
import com.example.black8snooker.activities.ChatlistActivity
import com.example.black8snooker.activities.LiveVideoActivity
import com.example.black8snooker.activities.LoginActivity
import com.example.black8snooker.databinding.ActivityLoginBinding
import com.example.black8snooker.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    /*binding = DataBindingUtil.s*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)



        binding.chatCardView.setOnClickListener {
            val intent = Intent(requireContext(), ChatlistActivity::class.java)
            requireContext().startActivity(intent)
        }

        binding.liveCardView.setOnClickListener {
            val intent = Intent(requireContext(), LiveVideoActivity::class.java)
            requireContext().startActivity(intent)
        }

        /* binding.aboutCardView.setOnClickListener {
             val intent = Intent(requireContext(),A::class.java)
             requireContext().startActivity(intent)
         }*/

        binding.aboutCardView.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_aboutFragment)
        }
        return binding.root
    }

}