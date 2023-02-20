package com.football.game.service;

import com.football.game.model.Game;
import com.football.game.model.MatchData;
import com.football.game.model.Player1;
import com.football.game.repository.GameRepo;
import com.football.game.repository.IGPlayerRepo;
import com.football.game.repository.MatchDataRepo;
import com.football.game.repository.Player1Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Service
public class GameService {

    @Autowired
    private Player1Service player1Service;

    @Autowired
    private final GameRepo gameRepo;

    @Autowired
    private final MatchDataRepo statsrepo;


    public GameService(IGPlayerRepo igPlayerRepo, Player1Repo player1Repo, Player1Service player1Service, GameRepo gameRepo, MatchDataRepo statsrepo) {
        this.player1Service = player1Service;
        this.gameRepo = gameRepo;
        this.statsrepo = statsrepo;
    }

    public Game NewGame(Game game){
        Player1 playerA = new Player1();
        Player1 playerB = new Player1();
        player1Service.CreateNewPlayer(playerA,1,6);
        player1Service.CreateNewPlayer(playerB,6,11);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        game.setCreation_date_and_time(dtf.format(now));
        game.setScore((double) 0);
        game.setGoals_scored_by_teamA(0);
        game.setGoals_scored_by_teamB(0);
        System.out.println(playerA.getUser_name() + "   playing with   " +playerB.getUser_name() + "\n");
        System.out.println(playerA.getTeam_assigned() + " VS "+ playerB.getTeam_assigned() + "\n");
        System.out.println("The game consists of 90 minutes in total with one half of 45 minutes each.\n");
        System.out.println("SCORECARD : \n");

        int y = (int) ((Math.random() * (10 - 1)) + 1);
        MatchData match = statsrepo.findByMatchid(y);

        System.out.println("Goals scored by "+ playerA.getTeam_assigned()+" in first half :" + match.getGoals_scrored_by_teamA_in_half_1()+"\n");
        System.out.println("Goals scored by "+ playerB.getTeam_assigned()+" in first half :"+match.getGoals_scrored_by_teamB_in_half_1() +"\n");
        System.out.println("Type 1 to begin the next half  and 0 to terminate the game\n");

        Scanner myObj = new Scanner(System.in);
        int entry = myObj.nextInt();

        if(entry == 1) {
            System.out.println("Goals scored by " + playerA.getTeam_assigned() + " in second half :" + match.getGoals_scrored_by_teamA_in_half_2()+"\n");
            System.out.println("Goals scored by " + playerB.getTeam_assigned() + " in second half :" + match.getGoals_scrored_by_teamB_in_half_2()+"\n");
            int team1_goals = match.getTeamA_goals();
            int team2_goals= match.getTeamB_goals();
            String winner;
            if(team1_goals>team2_goals) winner=playerA.getTeam_assigned();
            else if (team1_goals==team2_goals) winner = null;
            else winner=playerA.getTeam_assigned();
            System.out.println("The result of the game is : " + match.getTeamA_goals()+" - "+ match.getTeamB_goals() +"\n");
            if(winner == null)
                System.out.println("The game ended in a draw, thank you for playing!");
            else
                System.out.println("CONGRATULATIONS TO WINNING TEAM :" + winner);
        }
        else if (entry == 0) System.out.println("THE GAME HAS BEEN TERMINATED, THANK YOU FOR PLAYING!");

        return gameRepo.save(game);

    }


}
