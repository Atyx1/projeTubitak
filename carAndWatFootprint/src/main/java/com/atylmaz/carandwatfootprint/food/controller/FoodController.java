package com.atylmaz.carandwatfootprint.food.controller;

import com.atylmaz.carandwatfootprint.food.entity.Food;
import com.atylmaz.carandwatfootprint.food.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {



    private final FoodService foodService;

    @PostMapping("food/save")
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        try {
            Food savedFood = foodService.addFood(food);
            return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("food/delete/{id}")
    public ResponseEntity<Void> deleteFoodById(@PathVariable Integer id) {
        try {
            foodService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("food/{name}")
    public ResponseEntity<Food> findFoodByName(@PathVariable String name) {
        try {
            Food food = foodService.findByName(name);
            if (food != null) {
                return new ResponseEntity<>(food, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/show")
    public ResponseEntity<List<Food>> findAllFoods() {
         List<Food> foods = foodService.findAll();
         return new ResponseEntity<>(foods, HttpStatus.OK);

    }

    @PutMapping("food/update/{name}")
    public ResponseEntity<Void> updateFood(@PathVariable String name,@RequestBody Food food
                                           ) {
        try {
            foodService.update(name, food);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}