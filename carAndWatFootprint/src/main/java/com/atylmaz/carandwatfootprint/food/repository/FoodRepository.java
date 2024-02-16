package com.atylmaz.carandwatfootprint.food.repository;

import com.atylmaz.carandwatfootprint.food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

     Food findByFoodName(String foodName);
     Float findCarbonFootprintCcByFoodName(String foodName);
     Float findWaterFootprintCcByFoodName(String foodName);



}
