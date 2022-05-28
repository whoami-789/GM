package com.example.gm.exeptions;

import javax.validation.constraints.NotEmpty;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
