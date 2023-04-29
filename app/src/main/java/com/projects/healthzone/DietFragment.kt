package com.projects.healthzone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.projects.healthzone.databinding.FragmentDietBinding
import com.projects.healthzone.databinding.FragmentWorkoutPlanBinding

class DietFragment : Fragment() {
    private lateinit var binding: FragmentDietBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDietBinding.inflate(inflater, container, false)

        val args: DietFragmentArgs by navArgs()
        val weight = args.bmi

        var textResult = ""

        when {
            (weight < 18.5) -> textResult = " * Bodyweight squats: 3-4 sets of 8-12 reps\n" +
                    " * Push-ups: 3-4 sets of 8-12 reps\n" +
                    " * Lunges: 3-4 sets of 8-12 reps per leg\n" +
                    " * Dumbbell curls: 3-4 sets of 8-12 reps per arm\n" +
                    " * Dumbbell shoulder press: 3-4 sets of 8-12 reps\n" +
                    " * Pull-ups: 3-4 sets of 8-12 reps\n" +
                    " * Deadlifts: 3-4 sets of 8-12 reps"

            (weight > 25f) -> textResult = " * Jumping jacks: 3 sets of 20-30 reps\n" +
                    " * Bodyweight squats: 3 sets of 10-15 reps\n" +
                    " * High knees: 3 sets of 20-30 reps\n" +
                    " * Push-ups: 3 sets of 10-15 reps\n" +
                    " * Plank: 3 sets of 30-60 seconds\n" +
                    " * Mountain climbers: 3 sets of 20-30 reps\n" +
                    " * Burpees: 3 sets of 10-15 reps"
        }

        binding.textResult.text = textResult

        binding.buttonContinue.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_dietFragment_to_finishFragment)

        }

        return binding.root
    }


}