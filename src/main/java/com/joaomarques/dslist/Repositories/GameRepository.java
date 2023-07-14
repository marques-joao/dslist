package com.joaomarques.dslist.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaomarques.dslist.Entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> { // Nome da entidade e tipo do id
    
}
