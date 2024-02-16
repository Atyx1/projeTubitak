package com.atylmaz.carandwatfootprint.food.dto;

import lombok.Data;

@Data
public class CreateFoodDto {

      private String foodName;
      private float carbonFootprintCc;
      private float waterFootprintCc;


}
