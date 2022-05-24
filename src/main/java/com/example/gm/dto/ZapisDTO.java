package com.example.gm.dto;

import com.example.gm.models.Category;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ZapisDTO {
    private Long id;
    @NotEmpty
    private String date;
    @NotEmpty
    private String time;
    private Category category;
}
