package com.atylmaz.carandwatfootprint.meal.controller;


import com.atylmaz.carandwatfootprint.meal.dto.CreateMealDto;
import com.atylmaz.carandwatfootprint.meal.entity.Meal;
import com.atylmaz.carandwatfootprint.meal.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;


    @PostMapping("/add")
    public ResponseEntity<String> addMeal(@RequestBody CreateMealDto meal,@RequestParam List<String> foodNameList  ){

        try {
               mealService.addMeal(meal,foodNameList);
            return new ResponseEntity<>(meal.getMealName(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/show")
    public ResponseEntity<List<Meal>> showMeal(){
          List<Meal> meals = mealService.findAll();
        return new ResponseEntity<>(meals,HttpStatus.OK);
    }
}
