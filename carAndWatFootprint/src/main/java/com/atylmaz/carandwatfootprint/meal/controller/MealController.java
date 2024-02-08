package com.atylmaz.carandwatfootprint.meal.controller;


import com.atylmaz.carandwatfootprint.meal.entity.Meal;
import com.atylmaz.carandwatfootprint.meal.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController {

    private final MealService mealService;

    @PostMapping("/add")
    public ResponseEntity<Meal> addMeal(@RequestBody  Meal meal){

        try {
            Meal savedFood = mealService.addMeal(meal);
            return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
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
