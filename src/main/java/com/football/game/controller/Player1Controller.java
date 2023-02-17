package com.football.game.controller;

import com.football.game.model.Player1;
import com.football.game.service.Player1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user1")
public class Player1Controller {

    @Autowired
    public Player1Service service;


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Player1 adduser(@RequestBody Player1 player1){
        return service.CreateNewPlayer(player1,1,7);
    }


}
