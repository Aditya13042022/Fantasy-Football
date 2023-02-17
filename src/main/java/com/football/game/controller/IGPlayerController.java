package com.football.game.controller;

import com.football.game.model.IGplayers;
import com.football.game.service.IGPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player-database")
public class IGPlayerController {


    @Autowired
    public IGPlayerService igservice;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public IGplayers addplayer(@RequestBody IGplayers iGplayers) {
        return igservice.CreateNewIGPlayer(iGplayers);
    }

    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<IGplayers> addplayers(@RequestBody List<IGplayers> playerlist){
        return igservice.CreateNewIGPlayers(playerlist);
    }

    @GetMapping
    public List<IGplayers> getplayers() {
        return igservice.findallplayers();
    }

    @GetMapping("/jerseyno/{jerseyno}")
    public List<IGplayers> findByJerseyNo(@PathVariable int jerseyno){
        return igservice.getPlayersByJersey(jerseyno);
    }

}
