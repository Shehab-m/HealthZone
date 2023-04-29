package com.projects.healthzone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.projects.healthzone.databinding.FragmentCalculatorBinding
import com.projects.healthzone.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        val args: ResultFragmentArgs by navArgs()
        val myArg = args.bmi
        binding.textResultNumber.text = myArg
        val weight = binding.textResultNumber.text.toString().toFloat()

        when {
            (weight < 18.5) -> binding.textResult.text = "Underweight"
            (weight in 18.6f..25f) -> binding.textResult.text = "Normal"
            ( weight > 25f) -> binding.textResult.text = "Overweight"
        }

        binding.buttonContinue.setOnClickListener {
            val action = ResultFragmentDirections.actionResultFragmentToWorkoutPlanFragment(myArg.toFloat())
            findNavController().navigate(action)
        }

        return binding.root
    }


}