

package com.example.springboot.dto;

public class AuthResponse {

    private String token;

    public AuthResponse(String token){
        this.token = token;
    }

    public AuthResponse(){

    }

    public String getToken(){
        return this.token;
    }
}
