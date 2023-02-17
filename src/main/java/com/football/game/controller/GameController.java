package com.football.game.controller;

import com.football.game.model.Game;
import com.football.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stats")
public class GameController {

    @Autowired
    public GameService gameService;

/*    @RequestMapping("/home")
    public String home(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }*/

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Game NewGame(@RequestBody Game newgame){return gameService.NewGame(newgame);}

}
