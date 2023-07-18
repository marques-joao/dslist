package com.joaomarques.dslist.Entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity // Fazendo com que a classe se torne equivalente a uma tabela no banco de dados
@Table(name = "tb_game_list") // Definindo o nome da tabela
public class GameList {

    @Id // Define que o atributo logo abaixo é uma primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Faz com que a primary key seja auto incrementada
    private Long id;
    private String name;

    public GameList(){}

    public GameList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
         * Realiza um downcast do objeto passado como parâmetro, ou seja, converte o objeto para a classe GameList,
         * pois é necessário acessar os atributos específicos dessa classe para ser feita a comparação
         */
        GameList other = (GameList) obj; 

        return Objects.equals(id, other.id); // Retorna o resultado dessa comparação, sendo true ou false
    }
    
}