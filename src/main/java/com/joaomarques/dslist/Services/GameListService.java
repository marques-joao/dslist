package com.joaomarques.dslist.Services;

import com.joaomarques.dslist.DTO.GameListDTO;
import com.joaomarques.dslist.Entities.GameList;
import com.joaomarques.dslist.Repositories.GameListRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;
    
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
