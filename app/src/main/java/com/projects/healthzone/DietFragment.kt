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
                    "Total Calories per day : 2800 kcal "

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
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_dietFragment_to_finishFragment)

        }

        return binding.root
    }


}