package com.example.gm.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AddressDTO {
    private Long id;
    @NotEmpty
    private String name;
}
