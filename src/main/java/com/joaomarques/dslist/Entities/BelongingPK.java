package com.joaomarques.dslist.Entities;

import java.util.Objects;

import jakarta.persistence.*;

@Embeddable // Indicando que esta classe funciona como campos dentro de outra entity
public class BelongingPK { // Classe auxiliar para definir o id composto da classe Belonging

    @ManyToOne // Identificando que há um relacionamento N:N
    @JoinColumn(name = "game_id") // Define nome da coluna da chave estrangeira
    private Game game;
    
    @ManyToOne // Identificando que há um relacionamento N:N
    @JoinColumn(name = "list_id") // Define nome da coluna da chave estrangeira
    private GameList list;

    public BelongingPK(){}

    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
    
    public void setList(GameList list) {
        this.list = list;
    }

    public GameList getList() {
        return list;
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, list);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;

        BelongingPK other = (BelongingPK) obj;

        /*
         * Já que o id são dois objetos, então a comparação também precisa ser dupla 
         * e as duas precisam satisfazer a condição para retornar true
         */
        return Objects.equals(game, other.game) && Objects.equals(list, other.list);
    }
    
}