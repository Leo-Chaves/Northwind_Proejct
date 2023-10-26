package com.example.NorthwindProject.Model;

import lombok.Data;

@Data
public class ServiceResponse {
    Boolean sucess;
    String message;

    public ServiceResponse() {
        this.message = "Falha";
    }

    public Boolean getSucess() {
        return sucess;
    }

    public void setSucess(Boolean sucess) {
        this.sucess = sucess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
