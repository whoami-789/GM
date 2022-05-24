package com.example.gm.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class CategoryDTO {

    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private Integer price;
}
