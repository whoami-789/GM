package com.example.gm.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ZapisNotFoundException extends RuntimeException {
    public ZapisNotFoundException(String message) {
        super(message);
    }
}
