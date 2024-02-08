package com.atylmaz.carandwatfootprint.meal.repository;

import com.atylmaz.carandwatfootprint.meal.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
}
