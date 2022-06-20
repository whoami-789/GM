package com.example.gm.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CategoryDTO {

    private Long id;
    @NotEmpty
    private String title;
    @NotNull
    private Integer price;
}
