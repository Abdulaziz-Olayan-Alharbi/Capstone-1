package com.example.capstone_1.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coupon {
    @NotNull
    private int id;
    @NotNull
    @Min(5)
    private double percent;
    @NotNull
    private int productId;
    
}
