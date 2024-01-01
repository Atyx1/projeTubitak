package com.atylmaz.carandwatfootprint.meal;

import com.atylmaz.carandwatfootprint.food.Food;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meal")
public class Meal {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String  mealName;

   private float totalCarbonFootprintKg;
   private float totalWaterFootprintKg;
   private float totalCarbonFootprintCc;
   private float totalWaterFootprintCc;
   private Boolean isTrue;





}
