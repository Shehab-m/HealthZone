package com.projects.healthzone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.projects.healthzone.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        val currentWeight = 55
        val currentHeight = 100
        binding.textCurrentweight.text = currentWeight.toString()
        binding.textCurrentheight.text = currentHeight.toString()


        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textCurrentheight.text = "$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        binding.imageDecrementweight.setOnClickListener {
            binding.textCurrentweight.text = "${binding.textCurrentweight.text.toString().toInt() - 5}"
        }

        binding.imageIncremetweight.setOnClickListener {
            binding.textCurrentweight.text = "${binding.textCurrentweight.text.toString().toInt() + 5}"
        }

        binding.buttonCalculate.setOnClickListener {
            val heightString = binding.textCurrentheight.text.toString()
            val weightString = binding.textCurrentweight.text.toString()

            val heightInCM = heightString.toFloat()
            val weightInKg = weightString.toFloat()

            val heightInMeter = heightInCM / 100
            val heightInMeterSquare = heightInMeter * heightInMeter

            val bmi = weightInKg / heightInMeterSquare
            val bmiString = bmi.toString()

            val action = CalculatorFragmentDirections.actionCalculatorFragment2ToResultFragment(bmiString)
            findNavController().navigate(action)

        }


        return binding.root
    }


}