package io.github.iwag.finalproj.models.responsemodels;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorResponseModel {
    private String status;
    private String message;

    public ErrorResponseModel() {
    }

    public ErrorResponseModel(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
