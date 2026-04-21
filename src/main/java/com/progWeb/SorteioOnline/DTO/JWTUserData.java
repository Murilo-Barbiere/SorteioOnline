package com.progWeb.SorteioOnline.DTO;

public record JWTUserData(Long userId, String email) {
    public JWTUserData(Long userId, String email) {
        this.userId = userId;
        this.email = email;
    }
}