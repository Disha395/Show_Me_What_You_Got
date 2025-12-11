package com.example.ShowMeWhatYouGot_app.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddStarRequest {
    @NotBlank
    private String name;

}
