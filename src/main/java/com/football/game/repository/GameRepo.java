package com.football.game.repository;

import com.football.game.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepo extends MongoRepository<Game, String> {
}
