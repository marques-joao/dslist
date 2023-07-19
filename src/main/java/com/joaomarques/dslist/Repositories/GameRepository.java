package com.joaomarques.dslist.Repositories;

import com.joaomarques.dslist.Entities.Game;
import com.joaomarques.dslist.Projections.GameMinProjection;

import java.util.List;

/*
 * Biblioteca JpaRepository: Ela que automatiza o processo
 * de acesso aos dados, fazendo as consultas sem que seja 
 * necessário realizar os comandos de SQL
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
 * Camada de acesso aos dados. Esta classe que faz as consultas e 
 * retorna os dados a uma classe de serviço
 */
public interface GameRepository extends JpaRepository<Game, Long> { // Nome da entidade e tipo do id na List do Jpa
    
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
            
    List<GameMinProjection> searchByList(Long listId);
	
}