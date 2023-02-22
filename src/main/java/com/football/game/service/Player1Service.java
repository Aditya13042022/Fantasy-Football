package com.football.game.service;

import com.football.game.model.IGplayers;
import com.football.game.model.Player;
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

    public Player CreateNewPlayer(@NotNull Player newplayer1){
        System.out.println("Welcome Player, Firstly choose the team from the following list : \n");
        System.out.println(" 1:Barcelona \n 2:Real Madrid \n 3:PSG \n 4:Manchester-United \n 5:Manchester-City \n 6:Chelsea \n 7:Bayern Munich \n 8:Atletico Madrid \n 9:Juventus \n 10:Liverpool \n 11:Arsenal \n");
        Scanner myObj = new Scanner(System.in);
        int x = myObj.nextInt();
        System.out.println("Please enter your user name : \n");
        Scanner myobj = new Scanner(System.in);
        String user_name = myobj.nextLine();
        newplayer1.setUser_name(user_name);
        List<IGplayers> assignedteam = (List<IGplayers>) igPlayerRepo.findByJerseyno(x);
        newplayer1.setTeam((ArrayList<IGplayers>) assignedteam);
        IGplayers mockplayer = assignedteam.get(4);
        String team_name = mockplayer.getTeam_name();
        newplayer1.setTeam_assigned(team_name);
        return player1Repo.save(newplayer1);

    }




}
