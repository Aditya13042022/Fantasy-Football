package com.football.game.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    private long creation_date_and_time;

    private Integer  gameid;

    private String FirstTeam_name;

    private String SecondTeam_name;

    private int goals_scored_by_FirstTeam;

    private int goals_scored_by_SecondTeam;


}
