package com.football.game.repository;

import com.football.game.model.IGplayers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IGPlayerRepo extends MongoRepository<IGplayers, String> {

    List<IGplayers> findByJerseyno(int jerseyno);

}
