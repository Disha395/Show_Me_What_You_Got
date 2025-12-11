package com.example.ShowMeWhatYouGot_app.service;

import com.example.ShowMeWhatYouGot_app.model.Star;

import java.util.List;

public interface StarService {

    List<Star> getStarsSortedByCreated();

    List<Star> getStarsSortedByVotes();

    Star saveStar(Star star);

    Star getStarById(Long id);

    void incrementStarVotes(Star star);

}
