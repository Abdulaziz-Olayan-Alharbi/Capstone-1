package com.example.capstone_1.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotNull
    private int id;
    @NotNull
    private int productId;
    @NotNull
    private int merchantId;
    @NotNull
    @Min(11)
    private int stock;
}
