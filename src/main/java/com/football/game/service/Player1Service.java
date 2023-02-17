package com.football.game.service;

import com.football.game.model.IGplayers;
import com.football.game.model.Player1;
import com.football.game.repository.IGPlayerRepo;
import com.football.game.repository.Player1Repo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class Player1Service {
    @Autowired
    private final Player1Repo player1Repo;

    @Autowired
    private final IGPlayerRepo igPlayerRepo;


    public Player1Service(Player1Repo player1Repo, IGPlayerRepo igPlayerRepo) {
        this.player1Repo = player1Repo;
        this.igPlayerRepo = igPlayerRepo;
    }

    public Player1 CreateNewPlayer( @NotNull Player1 newplayer1,@NotNull int min, @NotNull int max){
        newplayer1.setScore((double) 0);
        int x = (int) ((Math.random() * (max - min)) + min);
        List<IGplayers> assignedteam = (List<IGplayers>) igPlayerRepo.findByJerseyno(x);
        newplayer1.setTeam((ArrayList<IGplayers>) assignedteam);
        return player1Repo.save(newplayer1);

    }




}
