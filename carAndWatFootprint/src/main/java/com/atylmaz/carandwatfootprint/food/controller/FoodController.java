package com.atylmaz.carandwatfootprint.food.controller;

import com.atylmaz.carandwatfootprint.food.dto.CreateFoodDto;
import com.atylmaz.carandwatfootprint.food.dto.UpdateFoodDto;
import com.atylmaz.carandwatfootprint.food.entity.Food;
import com.atylmaz.carandwatfootprint.food.exception.FoodNotFoundException;
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

    @PostMapping("/add")
    public ResponseEntity<Food> addFood(@RequestBody CreateFoodDto food) {
        try {
            Food savedFood = foodService.addFood(food);
            return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFoodById(@PathVariable Integer id) {
        try {
            foodService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (FoodNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{name}")
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

    @GetMapping("/showAll")
    public ResponseEntity<List<Food>> findAllFoods() {
         List<Food> foods = foodService.findAll();
         return new ResponseEntity<>(foods, HttpStatus.OK);

    }

    @PutMapping("food/update/{name}")
    public ResponseEntity<Void> updateFood(@PathVariable String name,@RequestBody UpdateFoodDto food
                                           ) {
        try {
            foodService.update(name, food);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}