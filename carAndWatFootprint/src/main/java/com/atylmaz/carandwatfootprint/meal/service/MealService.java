package com.atylmaz.carandwatfootprint.meal.service;


import com.atylmaz.carandwatfootprint.food.service.FoodService;
import com.atylmaz.carandwatfootprint.meal.entity.Meal;
import com.atylmaz.carandwatfootprint.meal.exception.MealNotFoundException;
import com.atylmaz.carandwatfootprint.meal.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {

    private  final MealRepository mealRepository;

    private final FoodService foodService;


    public Meal addMeal(Meal meal) {

        return mealRepository.save(meal);
    }

    public List<Meal> findAll() {
        return mealRepository.findAll();
    }

    public Meal deleteById(Integer id) {
        Meal meal = mealRepository.findById(id).orElseThrow(() -> new MealNotFoundException("Meal not found with id: " + id));
        mealRepository.delete(meal);
        return  meal;
    }

    public Meal findById(Integer id) {
        return mealRepository.findById(id).orElseThrow( () -> new MealNotFoundException("Meal not found with id: " + id));
    }


}
