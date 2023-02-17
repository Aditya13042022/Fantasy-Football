package com.football.game.repository;

import com.football.game.model.MatchData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchDataRepo extends MongoRepository<MatchData,Integer> {
    MatchData findByMatchid(int matchid);
}
