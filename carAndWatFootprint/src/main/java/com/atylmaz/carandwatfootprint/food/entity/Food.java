package com.atylmaz.carandwatfootprint.food.entity;

import com.atylmaz.carandwatfootprint.meal.entity.Meal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String foodName;

    private float carbonFootprintCc;
    private float waterFootprintCc;



    public Food(String foodName, float carbonFootprintCc, float waterFootprintCc) {
        this.foodName = foodName;
        this.carbonFootprintCc = carbonFootprintCc;
        this.waterFootprintCc = waterFootprintCc;
    }
}

