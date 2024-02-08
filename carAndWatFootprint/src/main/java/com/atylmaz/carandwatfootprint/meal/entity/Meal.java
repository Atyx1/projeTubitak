package com.atylmaz.carandwatfootprint.meal.entity;


import com.atylmaz.carandwatfootprint.food.entity.Food;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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




    public void setTotalCarbonFootprintCc(float totalCarbonFootprintCc) {

          foodList.forEach(food -> {
             this.totalCarbonFootprintCc += food.getWaterFootprintCc();
        });


    }


    public void setTotalWaterFootprintCc(float totalWaterFootprintCc) {

        foodList.forEach(food -> {
            this.totalWaterFootprintCc += food.getWaterFootprintCc();
        });
    }

    public void calculateTotalCarbonFootprint() {
    foodList.forEach(food -> {
        this.totalCarbonFootprintCc += food.getCarbonFootprintCc();
    });
}

public void calculateTotalWaterFootprint() {
    foodList.forEach(food -> {
        this.totalWaterFootprintCc += food.getWaterFootprintCc();
    });
}


  public void setStatus(Status status) {
    if (totalCarbonFootprintCc > 0 && totalCarbonFootprintCc < 150) {
        this.status = Status.GOOD;
    } else if (totalCarbonFootprintCc >= 150 && totalCarbonFootprintCc < 300) {
        this.status = Status.MEDIUM;
    } else {
        this.status = Status.BAD;
    }
}

}
