package io.github.iwag.finalproj.controllers;

import io.github.iwag.finalproj.models.responsemodels.ErrorResponseModel;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

class OurApplicationException  extends WebApplicationException {
     public OurApplicationException(Integer status, String message) {
         super(Response.status(status)
                 .entity(new ErrorResponseModel(status.toString(), message))
                 .type(MediaType.APPLICATION_JSON_TYPE).build());
     }
}
