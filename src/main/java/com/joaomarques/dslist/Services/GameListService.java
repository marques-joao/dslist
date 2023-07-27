package com.joaomarques.dslist.Services;

import com.joaomarques.dslist.DTO.GameListDTO;
import com.joaomarques.dslist.Entities.GameList;
import com.joaomarques.dslist.Projections.GameMinProjection;
import com.joaomarques.dslist.Repositories.GameListRepository;
import com.joaomarques.dslist.Repositories.GameRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;
    
    @Autowired
    private GameRepository gameRepository;
    
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
    
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}