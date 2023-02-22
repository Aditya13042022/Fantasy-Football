package com.football.game.controller;

import com.football.game.model.Player;
import com.football.game.service.Player1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user1")
public class Player1Controller {

    @Autowired
    public Player1Service service;


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Player adduser(@RequestBody Player player1){
        return service.CreateNewPlayer(player1);
    }


}
