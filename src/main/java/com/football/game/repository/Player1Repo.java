package com.football.game.repository;

import com.football.game.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface Player1Repo extends MongoRepository<Player,String> {

}
