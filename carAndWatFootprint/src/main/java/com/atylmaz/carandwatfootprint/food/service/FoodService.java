package com.atylmaz.carandwatfootprint.food.service;


import com.atylmaz.carandwatfootprint.food.dto.CreateFoodDto;
import com.atylmaz.carandwatfootprint.food.dto.UpdateFoodDto;
import com.atylmaz.carandwatfootprint.food.entity.Food;
import com.atylmaz.carandwatfootprint.food.exception.FoodNotFoundException;
import com.atylmaz.carandwatfootprint.food.repository.FoodRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Food addFood( CreateFoodDto createFoodDto) {
        return foodRepository.save(modelMapper.map(createFoodDto, Food.class));

    }

    @Transactional
    public void deleteById(Integer id) {
        Food food = foodRepository.findById(id).orElseThrow(() -> new FoodNotFoundException("Food not found with id: " + id));
        foodRepository.delete(food);

    }

    public Food findByName(String name) {
      Food food = foodRepository.findByFoodName(name);
        return food;
    }

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public void update(String name, UpdateFoodDto createFoodDto) {
        Food food1= foodRepository.findByFoodName(name);
        foodRepository.save(modelMapper.map(createFoodDto, Food.class));

    }


}
