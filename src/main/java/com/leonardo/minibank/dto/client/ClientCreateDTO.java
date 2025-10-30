package com.leonardo.minibank.dto.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClientCreateDTO {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    public ClientCreateDTO(){}

    public ClientCreateDTO (String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
