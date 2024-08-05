package com.example.capstone_1.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Category {
    @NotNull
    private int id;
    @NotEmpty
    @Size(min = 4, max = 25)
    private String name;
}
