package com.football.game.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "user1")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Player1 {


    @Id
    private String user_name;

    private String password;

    private String email;

    private Double score;

    private String team_assigned;

    ArrayList<IGplayers> team;


}
