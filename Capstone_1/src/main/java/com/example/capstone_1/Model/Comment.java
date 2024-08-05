package com.example.capstone_1.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
    @NotNull
    private int id;
    @Size(max = 250)
    private String text;
    @Min(1)
    @Max(10)
    private double score;
    @NotNull
    private int userId;
    @NotNull
    private int productId;

}
