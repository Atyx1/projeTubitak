package com.atylmaz.carandwatfootprint.meal.service;


import com.atylmaz.carandwatfootprint.food.entity.Food;
import com.atylmaz.carandwatfootprint.food.repository.FoodRepository;
import com.atylmaz.carandwatfootprint.food.service.FoodService;
import com.atylmaz.carandwatfootprint.meal.dto.CreateMealDto;
import com.atylmaz.carandwatfootprint.meal.entity.Meal;
import com.atylmaz.carandwatfootprint.meal.exception.MealNotFoundException;
import com.atylmaz.carandwatfootprint.meal.repository.MealRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {

    private  final MealRepository mealRepository;

    private final FoodRepository foodRepository;





    public void addMeal(CreateMealDto createMealDto, List<String> foodNameList) {
        try {
            Meal meal = new Meal();
            meal.setMealName(createMealDto.getMealName()); // createMealDto'dan meal ismini al
            float totalCarbonFootprintCc = 0;
            float totalWaterFootprintCc = 0;
            List<Food> foodList = new ArrayList<>();

            for (String foodName : foodNameList) {

                Float carbonFootprint = foodRepository.findCarbonFootprintCcByFoodName(foodName);
                Float waterFootprint = foodRepository.findWaterFootprintCcByFoodName(foodName);

                if (carbonFootprint != null && waterFootprint != null) {
                    totalCarbonFootprintCc += carbonFootprint;
                    totalWaterFootprintCc += waterFootprint;
                    Food food = foodRepository.findByFoodName(foodName);
                     meal.addFood(food);
                    if (food != null) {
                        foodList.add(food);
                    }
                }
            }


            meal.setTotalCarbonFootprintCc(totalCarbonFootprintCc);
            meal.setTotalWaterFootprintCc(totalWaterFootprintCc);
            meal.setFoodList(foodList);
            meal.setStatus(totalCarbonFootprintCc, totalWaterFootprintCc); // setStatus metodunun tanımlanması gerekiyor
            mealRepository.save(meal);
        } catch (Exception e) {
            System.out.println(e);
        }
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
