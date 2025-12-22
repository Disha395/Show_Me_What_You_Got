package com.example.ShowMeWhatYouGot_app.controller;

import com.example.ShowMeWhatYouGot_app.model.Star;
import com.example.ShowMeWhatYouGot_app.service.StarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StarUIController {

    private final StarService starService;

    public StarUIController(StarService starService) {
        this.starService = starService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/stars-list")
    public String starsList(Model model) {
        model.addAttribute("stars", starService.getStarsSortedByCreated());
        return "stars-list";
    }

    @GetMapping("/stars-rank")
    public String starsRank(Model model) {
        model.addAttribute("stars", starService.getStarsSortedByVotes());
        return "stars-rank";
    }

    @GetMapping("/add-stars")
    public String addStars(Model model) {
        model.addAttribute("addStarRequest", new AddStarRequest());
        return "add-stars";
    }

    @PostMapping("/add-star")
    public String addStar(@Valid AddStarRequest addStarRequest, BindingResult result) {
        if (result.hasErrors()) {
            return "add-stars";
        }
        Star star = new Star();
        star.setName(addStarRequest.getName());
        starService.saveStar(star);
        return "redirect:/stars-list";
    }

    @GetMapping("/vote-stars/{id}")
    public String voteStar(@PathVariable Long id) {
        Star star = starService.getStarById(id);
        starService.incrementStarVotes(star);
        return "redirect:/stars-list";
    }
}