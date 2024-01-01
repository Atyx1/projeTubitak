package com.atylmaz.carandwatfootprint.food;


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

    public void deleteById(Integer id) {
        foodRepository.deleteById(id);
    }

    public Food findByName(String name) {
        Food food = foodRepository.findByFoodName(name);
        return food;
    }

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public void update(String name, Food food) {
        Food food_1 = foodRepository.findByFoodName(name);
        food_1.setCarbonFootprintKg(food.getCarbonFootprintKg());
        food_1.setWaterFootprintKg(food.getWaterFootprintKg());
        food_1.setCarbonFootprintCc(food.getCarbonFootprintCc());
        food_1.setWaterFootprintCc(food.getWaterFootprintCc());

        foodRepository.save(food);
    }


}
