package com.example.ShowMeWhatYouGot_app.controller;

import jakarta.validation.constraints.NotBlank;

public class AddStarRequest {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
