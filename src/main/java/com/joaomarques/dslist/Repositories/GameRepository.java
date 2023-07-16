package com.joaomarques.dslist.Repositories;

/*
 * Biblioteca JpaRepository: Ela que automatiza o processo
 * de acesso aos dados, fazendo as consultas sem que seja 
 * necessário realizar os comandos de SQL
*/
import org.springframework.data.jpa.repository.JpaRepository;

import com.joaomarques.dslist.Entities.Game;

/*
 * Camada de acesso aos dados. Esta classe que faz as consultas e 
 * retorna os dados a uma classe de serviço
 */
public interface GameRepository extends JpaRepository<Game, Long> {} // Nome da entidade e tipo do id na List do Jpa
