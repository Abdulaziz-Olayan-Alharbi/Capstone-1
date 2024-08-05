package com.example.capstone_1.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Product {
    @NotNull
    private int id;
    @NotEmpty
    @Size(min = 4, max = 40)
    private String name;
    @NotNull
    private double price;
    @NotNull
    private int categoryId;
}
