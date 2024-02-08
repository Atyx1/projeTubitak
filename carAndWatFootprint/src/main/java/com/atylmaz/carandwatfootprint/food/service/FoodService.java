package com.atylmaz.carandwatfootprint.food.service;


import com.atylmaz.carandwatfootprint.food.entity.Food;
import com.atylmaz.carandwatfootprint.food.exception.FoodNotFoundException;
import com.atylmaz.carandwatfootprint.food.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    public Food deleteById(Integer id) {
        Food food = foodRepository.findById(id).orElseThrow(() -> new FoodNotFoundException("Food not found with id: " + id));
        foodRepository.delete(food);
        return food;
    }

    public Food findByName(String name) {
      Food food = foodRepository.findByFoodName(name);
        return food;
    }

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public void update(String name, Food food) {
        foodRepository.save(food);
    }


}
