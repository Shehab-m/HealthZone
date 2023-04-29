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
            (weight < 18.5) -> textResult = "Breakfast :\n" +
                    "( Oats(100g) _ Peanuts(50g) _ Milk(280g) _ Honey(15g) )\n" +
                    "Total : 859 kcal\n" +
                    "\n" +
                    "Lunch : \n" +
                    "( Chicken Breast(200g) _ White Rice(300g) )\n" +
                    "Total : 777 kcal\n" +
                    "\n" +
                    "Dinner :\n" +
                    "( Tuna in Water (Canned)(140g) _ Cottage Cheese(100g) _ Potato(200g) )\n" +
                    "Total : 457 kcal \n" +
                    "\n" +
                    "Snacks/Other :\n" +
                    "( Pita Bread(140g) _ Egg(200g) )\n" +
                    "Total : 679 kcal \n" +
                    "\n" +
                    "Total Calories per day : 2800 kcal"

            (weight in 18.6f..25f) -> textResult =
                "Congratulations on achieving a normal BMI result!.\n" +
                        "This is a fantastic achievement and a reflection of your hard work\n" +
                        "and dedication towards leading a healthy lifestyle.\n"

            (weight > 25f) -> textResult = "Breakfast :\n" +
                    "( Oats(50g) _ Peanuts(20g) _ Milk(150g) _ Honey(7g) )\n" +
                    "Total : 448 kcal\n" +
                    "\n" +
                    "Lunch : \n" +
                    "( Chicken Breast(150g) _ White Rice(150g) )\n" +
                    "Total : 487 kcal\n" +
                    "\n" +
                    "Dinner :\n" +
                    "( Tuna in Water (Canned)(140g) _ Cottage Cheese(100g) )\n" +
                    "Total : 249 kcal \n" +
                    "\n" +
                    "Snacks/Other :\n" +
                    "( Pita Bread(70g) _ Egg(100g) )\n" +
                    "Total : 339 kcal \n" +
                    "\n" +
                    "Total Calories per day : 1500 kcal"
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