package com.example.ShowMeWhatYouGot_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
public class Star {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String avatarUrl;

    private int votes = 0;

    private Instant created = Instant.now();

}
