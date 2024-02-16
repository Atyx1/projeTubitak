package com.atylmaz.carandwatfootprint.meal.entity;


import com.atylmaz.carandwatfootprint.food.entity.Food;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "meal")
public class Meal {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String  mealName;

   private float totalCarbonFootprintCc;
   private float totalWaterFootprintCc;
   private Status status;


   @OneToMany
   private List<Food> foodList;



public void addFood(Food food){
    if(foodList == null){
        foodList = new ArrayList<>();
    }
    foodList.add(food);
}

public void removeFood(Food food) {
    if (foodList != null) {
        foodList.remove(food);
    }
}



  public void setStatus(float totalCarbonFootprintCc, float totalWaterFootprintCc) {
    if (totalCarbonFootprintCc > 0 && totalCarbonFootprintCc < 150) {
        this.status = Status.GOOD;
    } else if (totalCarbonFootprintCc >= 150 && totalCarbonFootprintCc < 300) {
        this.status = Status.MEDIUM;
    } else {
        this.status = Status.BAD;
    }
}

}
