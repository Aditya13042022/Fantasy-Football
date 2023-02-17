package com.football.game.service;

import com.football.game.model.MatchData;
import com.football.game.repository.MatchDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    public final MatchDataRepo repo;

    public MatchService(MatchDataRepo repo) {
        this.repo = repo;
    }


    public MatchData createNewMatch(MatchData match){
        return repo.save(match);
    }

    public MatchData findbyid(int matchid){
        return repo.findByMatchid(matchid);
    }
}
