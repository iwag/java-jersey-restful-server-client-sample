package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.responsemodels.ErrorResponseModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class BaseController {
    @ExceptionHandler({ OurApplicationException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            OurApplicationException ex, WebRequest request) {
        return new ResponseEntity<Object>(new ErrorResponseModel(ex.getStatus().toString(), ex.getMessage()), new HttpHeaders(), ex.getStatus());
    }
}
