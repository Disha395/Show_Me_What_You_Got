package com.example.ShowMeWhatYouGot_app.controller;

import com.example.ShowMeWhatYouGot_app.model.Star;
import com.example.ShowMeWhatYouGot_app.service.StarService;
import com.example.ShowMeWhatYouGot_app.service.StarServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StarApiController {

    private final StarService starService;
    @GetMapping("/star")
    private List<Star> getStars(){
        return starService.getStarsSortedByCreated();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/stars")
    public Star addStar(@Valid @RequestBody AddStarRequest addStarRequest) {
        Star star = new Star();
        star.setName(addStarRequest.getName());
        star = starService.saveStar(star);
        return star;
    }
}
