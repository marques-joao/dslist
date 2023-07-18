package com.joaomarques.dslist.Repositories;

import com.joaomarques.dslist.Entities.GameList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {}
