package com.football.game.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "results")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchData {

    @Id
    private int matchid;

    private int teamA_goals;

    private int teamB_goals;

    private int goals_scrored_by_teamA_in_half_1;

    private int goals_scrored_by_teamA_in_half_2;

    private int goals_scrored_by_teamB_in_half_1;

    private int goals_scrored_by_teamB_in_half_2;


}
