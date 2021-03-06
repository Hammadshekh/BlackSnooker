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
import com.example.black8snooker.activities.*
import com.example.black8snooker.databinding.FragmentHomeBinding
import com.example.black8snooker.databinding.FragmentSettingBinding
import com.google.firebase.auth.FirebaseAuth


class SettingFragment : Fragment() {

    private lateinit var binding: FragmentSettingBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        auth = FirebaseAuth.getInstance()

        binding.logoutBtn.setOnClickListener {
            auth.signOut()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        binding.profleLayout.setOnClickListener {
         val intent = Intent(requireActivity(),ProfileActivity::class.java)
             requireActivity().startActivity(intent)
        }

        binding.ruleSnookerLayout.setOnClickListener {
            val intent = Intent(requireActivity(), RuleActivity::class.java)
            requireActivity().startActivity(intent)
        }

        binding.privacyLayout.setOnClickListener {
            val intent = Intent(requireActivity(),PrivacyActivity::class.java)
            requireActivity().startActivity(intent)
        }

        binding.aboutLayout.setOnClickListener {
            val intent = Intent(requireActivity(),AboutActivity::class.java)
            requireActivity().startActivity(intent)
        }
        return binding.root
    }
}