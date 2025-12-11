package com.example.ShowMeWhatYouGot_app.service;

import com.example.ShowMeWhatYouGot_app.client.DiceBearClient;
import com.example.ShowMeWhatYouGot_app.model.Star;
import com.example.ShowMeWhatYouGot_app.repository.StarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StarServiceImpl implements StarService{
    private final StarRepository starRepository;
    private final DiceBearClient diceBearClient;
    @Override
    public List<Star> getStarsSortedByCreated() {
        return starRepository.findAllByOrderByCreatedDesc();
    }

    @Override
    public List<Star> getStarsSortedByVotes() {
        return starRepository.findAllByOrderByVotesDesc();
    }

    @Override
    public Star saveStar(Star star) {
        star.setAvatarUrl(diceBearClient.getAvatar(star.getName()));
        return starRepository.save(star);
    }

    @Override
    public Star getStarById(Long id) {
        return starRepository.findById(id).orElseThrow(() -> new RuntimeException("Star with ID '%s' not found!".formatted(id)));
    }

    @Override
    public void incrementStarVotes(Star star) {
        star.setVotes(star.getVotes() + 1);
        saveStar(star);
    }
}
