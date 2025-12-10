package com.example.ShowMeWhatYouGot_app.repository;

import com.example.ShowMeWhatYouGot_app.model.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {
    List<Star> findAllByOrderByCreatedDesc();

    List<Star> findAllByOrderByVotesDesc();
}
