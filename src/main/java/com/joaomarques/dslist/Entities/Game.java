package com.joaomarques.dslist.Entities;

import java.util.Objects;

import jakarta.persistence.*;

@Entity // Fazendo com que a classe se torne equivalente a uma tabela no banco de dados
@Table(name = "tb_game") // Definindo o nome da tabela
public class Game {

    @Id // Define que o atributo logo abaixo é uma primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Faz com que a primary key seja auto incrementada
    private Long id;
    private String title;

    @Column(name = "game_year") // Alterando o nome da coluna de 'year' para 'game_year', pois no SQL 'year' é uma palavra reservada
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    
    /* 
     * Por padrão, o tipo String do Java é identificado como um varchar(255) no SQL,
     * porém os textos colocados como valor do atributo podem ultrapassar esse limite,
     * por isso a anotação @Column com o parâmetro columnDefinition, para que possamos 
     * alterar o tipo de varchar(255) para text, que aceita muito mais caracteres
     */
    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String longDescription;

    public Game(){}

    public Game(Long id, String title, Integer year, String genre, String platforms,
                Double score, String imgUrl, String shortDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.score = score;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }
    
    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }
    
    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }
    
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
    
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }
    
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
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
         * Realiza um downcast do objeto passado como parâmetro, ou seja, converte o objeto para a classe Game,
         * pois é necessário acessar os atributos específicos dessa classe para ser feita a comparação
         */
        Game other = (Game) obj; 

        return Objects.equals(id, other.id); // Retorna o resultado dessa comparação, sendo true ou false
    }
    
}