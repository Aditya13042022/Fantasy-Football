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
    private String creation_date_and_time;

    private Integer  gameid;

    private Double score;

    private int goals_scored_by_teamA;

    private int goals_scored_by_teamB;


}
