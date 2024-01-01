package com.atylmaz.carandwatfootprint.food;

import com.atylmaz.carandwatfootprint.meal.Meal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String foodName;
    private float carbonFootprintKg;
    private float waterFootprintKg;
    private float carbonFootprintCc;
    private float waterFootprintCc;


}

