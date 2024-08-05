package com.example.capstone_1.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    @NotNull
    private int id;
    @NotNull
    private int userId;
    @NotNull
    private int productId;
    @NotNull
    private int merchantId;
    @NotEmpty
    @Pattern(regexp = "^(Received|Shipping|Shipped)$")
    private String status = "Received";

}
