package org.example.productsbackend.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiErrorResponse {

    private String message;
    private String path;
    private int status;
    private LocalDateTime time;
}