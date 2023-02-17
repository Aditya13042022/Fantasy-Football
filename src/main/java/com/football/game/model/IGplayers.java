package com.football.game.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "player-database")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class IGplayers {
    @Id
    private String player_name;

    private String team_name;

    private int ovr;

    private int jerseyno;


}
