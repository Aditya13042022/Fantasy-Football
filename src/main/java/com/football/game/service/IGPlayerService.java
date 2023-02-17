package com.football.game.service;

import com.football.game.model.IGplayers;
import com.football.game.repository.IGPlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class IGPlayerService {

    @Autowired
    private final IGPlayerRepo igPlayerRepo;

    public IGPlayerService(IGPlayerRepo igPlayerRepo) {
        this.igPlayerRepo = igPlayerRepo;
    }

    public IGplayers CreateNewIGPlayer(IGplayers newplayer)
    {
        return igPlayerRepo.save(newplayer);
    }

    public List<IGplayers> CreateNewIGPlayers(List<IGplayers> playerlist){
        return igPlayerRepo.saveAll(playerlist);}

    public List<IGplayers> findallplayers(){return igPlayerRepo.findAll();}

    public List<IGplayers> getPlayersByJersey(int jerseyno){
        return igPlayerRepo.findByJerseyno(jerseyno);
    }

}
