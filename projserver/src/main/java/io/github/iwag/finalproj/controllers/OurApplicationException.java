package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.responsemodels.ErrorResponseModel;
import org.springframework.http.HttpStatus;


class OurApplicationException  extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public OurApplicationException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
     }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
