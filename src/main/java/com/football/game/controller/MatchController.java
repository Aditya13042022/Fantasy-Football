package com.football.game.controller;
import com.football.game.model.IGplayers;
import com.football.game.model.MatchData;
import com.football.game.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class MatchController {

    @Autowired
    public MatchService matchService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public MatchData NewModel(@RequestBody MatchData match){
        return matchService.createNewMatch(match);
    }

    @GetMapping("/{matchid}")
    public MatchData findByMatchid(@PathVariable int matchid){
        return matchService.findbyid(matchid);
    }
}
