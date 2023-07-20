package com.joaomarques.dslist.Entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_belonging")
public class Belonging {
    
    // Anotação que indica um id originado de outra classe Embeddable
    @EmbeddedId
    private BelongingPK id = new BelongingPK();
    private Integer position;

    public Belonging(){}

    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }
    
    public void setId(BelongingPK id) {
        this.id = id;
    }

    public BelongingPK getId() {
        return id;
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;

        Belonging other = (Belonging) obj;

        return Objects.equals(id, other.id);
    }
    
}