package com.joaomarques.dslist.Entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity // Fazendo com que a classe se torne equivalente a uma tabela no banco de dados
@Table(name = "tb_belonging") // Definindo o nome da tabela
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

    /* Métodos para comparar um objeto com outro */

    @Override
    public int hashCode() {
        return Objects.hash(id); // Retorna o identificador de um objeto
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) // Compara se o objeto atual e o objeto passado como parâmetro são iguais
            return true;
        if(obj == null) // Confere se o objeto passado como parâmetro é nulo
            return false;
        if(getClass() != obj.getClass()) // Compara se as classes dos objetos são iguais
            return false;

        /*
         * Realiza um downcast do objeto passado como parâmetro, ou seja, converte o objeto para a classe Belonging,
         * pois é necessário acessar os atributos específicos dessa classe para ser feita a comparação
         */
        Belonging other = (Belonging) obj;

        return Objects.equals(id, other.id); // Retorna o resultado dessa comparação, sendo true ou false
    }
    
}