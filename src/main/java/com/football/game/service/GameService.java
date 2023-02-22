package com.football.game.service;

import com.football.game.model.Game;
import com.football.game.model.Player;
import com.football.game.repository.GameRepo;
import com.football.game.repository.IGPlayerRepo;
import com.football.game.repository.Player1Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class GameService {

    @Autowired
    private Player1Service player1Service;

    @Autowired
    private final GameRepo gameRepo;


    public GameService(IGPlayerRepo igPlayerRepo, Player1Repo player1Repo, Player1Service player1Service, GameRepo gameRepo) {
        this.player1Service = player1Service;
        this.gameRepo = gameRepo;
    }

    public Game NewGame(Game game){
        Player FirstPlayer = new Player();
        Player SecondPlayer = new Player();
        player1Service.CreateNewPlayer(FirstPlayer);
        player1Service.CreateNewPlayer(SecondPlayer);
        long unixTime = Instant.now().getEpochSecond();
        game.setCreation_date_and_time(unixTime);
        System.out.println(FirstPlayer.getUser_name() + "   playing with   " +SecondPlayer.getUser_name() + "\n");
        System.out.println(FirstPlayer.getTeam_assigned() + " VS "+ SecondPlayer.getTeam_assigned() + "\n");
        System.out.println("The game consists of 90 minutes in total with one half of 45 minutes each.\n");
        System.out.println("SCORECARD : \n");

        int team1_goals = (int) ((Math.random() * (10 - 1)) + 1);
        int team2_goals = (int) ((Math.random() * (10 - 1)) + 1);

            String winner;
            if(team1_goals>team2_goals) winner=FirstPlayer.getTeam_assigned();
            else if (team1_goals==team2_goals) winner = null;
            else winner=SecondPlayer.getTeam_assigned();


            System.out.println("The result of the game is : " + team1_goals+" - "+ team2_goals +"\n");

            if(winner == null) {
                System.out.println("The game ended in a draw, thank you for playing! \n");
                System.out.println("The Player of the Match award goes to : " + FirstPlayer.getTeam().get(1).getPlayer_name() + "\n");

            }
            else {
                System.out.println("CONGRATULATIONS TO WINNING TEAM :" + winner);
                if(winner == FirstPlayer.getTeam_assigned())
                    System.out.println("The Player of the Match award goes to : " + FirstPlayer.getTeam().get(0).getPlayer_name() + "\n");
                else
                    System.out.println("The Player of the Match award goes to : " + SecondPlayer.getTeam().get(0).getPlayer_name() + "\n");
            }

        game.setGoals_scored_by_FirstTeam(team1_goals);
        game.setGoals_scored_by_SecondTeam(team2_goals);
        game.setFirstTeam_name(FirstPlayer.getTeam_assigned());
        game.setSecondTeam_name(SecondPlayer.getTeam_assigned());

        return gameRepo.save(game);

    }


}
