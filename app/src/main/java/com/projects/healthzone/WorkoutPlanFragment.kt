package com.projects.healthzone

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.projects.healthzone.databinding.FragmentWorkoutPlanBinding

class WorkoutPlanFragment : Fragment() {
    private lateinit var binding: FragmentWorkoutPlanBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWorkoutPlanBinding.inflate(inflater, container, false)
        val args: WorkoutPlanFragmentArgs by navArgs()
        val weight = args.bmi

        var textResult = ""

        when {
            (weight < 18.5) -> textResult = " * Bodyweight squats: 3-4 sets of 8-12 reps\" \n" +
                    " * Push-ups: 3-4 sets of 8-12 reps\n" +
                    " * Lunges: 3-4 sets of 8-12 reps per leg\n" +
                    " * Dumbbell curls: 3-4 sets of 8-12 reps per arm\n" +
                    " * Dumbbell shoulder press: 3-4 sets of 8-12 reps\n" +
                    " * Pull-ups: 3-4 sets of 8-12 reps\n" +
                    "* Deadlifts: 3-4 sets of 8-12 reps"

            (weight in 18.6f..25f) -> textResult =
                "Congratulations on achieving a normal BMI result!.\n" +
                        "This is a fantastic achievement and a reflection of your hard work\n" +
                        "and dedication towards leading a healthy lifestyle.\n"

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
            if (weight in 18.6f..25f) {
                findNavController().navigate(
                    WorkoutPlanFragmentDirections.actionWorkoutPlanFragmentToFinishFragment(
                        weight
                    )
                )
            } else {
                val action =
                    WorkoutPlanFragmentDirections.actionWorkoutPlanFragmentToDietFragment(weight)
                findNavController().navigate(action)
            }
        }
        return binding.root
    }

}