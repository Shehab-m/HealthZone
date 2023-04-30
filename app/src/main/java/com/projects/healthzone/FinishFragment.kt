package com.projects.healthzone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.projects.healthzone.databinding.FragmentFinishBinding
import com.projects.healthzone.databinding.FragmentWelcomeBinding

class FinishFragment : Fragment() {
    private lateinit var binding: FragmentFinishBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinishBinding.inflate(inflater, container, false)

        binding.buttonFinish.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_finishFragment_to_calculatorFragment2)
        }


        return binding.root
    }
}

