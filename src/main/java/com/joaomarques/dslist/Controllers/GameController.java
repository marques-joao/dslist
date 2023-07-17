package com.joaomarques.dslist.Controllers;

import com.joaomarques.dslist.DTO.*;
import com.joaomarques.dslist.Services.GameService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // Classe que envia as requisições web para o frontend
@RequestMapping(value = "/games") // Definindo o caminho no site
public class GameController {

    @Autowired
    private GameService gameService; // Injetando uma instância do GameService no GameController

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping // Verbo GET do http (método para retornar algum dado)
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll(); // Chamando o método findAll() da classe GameService
        return result;
    }
}
