package com.example.gm.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
public class ZapisDTO {
    private Long id;
    @NotEmpty
    private String date;
    @NotEmpty
    private String time;
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastname;
    @NotEmpty
    private Long category;

    public ZapisDTO() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ZapisDTO;
    }

}
