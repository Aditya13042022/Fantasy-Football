package com.football.game.service;

import com.football.game.model.Game;
import com.football.game.model.Player1;
import com.football.game.repository.GameRepo;
import com.football.game.repository.IGPlayerRepo;
import com.football.game.repository.Player1Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class GameService {
    @Autowired
    private final IGPlayerRepo igPlayerRepo;

    @Autowired
    private final Player1Repo player1Repo;

    @Autowired
    private Player1Service player1Service;

    @Autowired
    private final GameRepo gameRepo;


    public GameService(IGPlayerRepo igPlayerRepo, Player1Repo player1Repo, Player1Service player1Service, GameRepo gameRepo) {
        this.igPlayerRepo = igPlayerRepo;
        this.player1Repo = player1Repo;
        this.player1Service = player1Service;
        this.gameRepo = gameRepo;
    }

    public Game NewGame(Game game){
        Player1 playerA = new Player1();
        Player1 playerB = new Player1();
        player1Service.CreateNewPlayer(playerA,1,6);
        player1Service.CreateNewPlayer(playerB,6,11);
        String teamA = playerA.getTeam_assigned();
        String teamB = playerB.getTeam_assigned();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        game.setCreation_date_and_time(dtf.format(now));
        game.setScore((double) 0);
        game.setGoals_scored_by_teamA(0);
        game.setGoals_scored_by_teamB(0);
        System.out.println("Player 1 : " + playerA.getUser_name() + " Playing with  " + "Player 2 : " + playerB.getUser_name() + "\n");
        System.out.println(teamA + " VS "+ teamB);

        return gameRepo.save(game);

    }


}
