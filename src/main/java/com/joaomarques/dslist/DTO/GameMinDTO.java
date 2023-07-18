package com.joaomarques.dslist.DTO;

import com.joaomarques.dslist.Entities.Game;

public class GameMinDTO {
    
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(){}

    public GameMinDTO(Game entity) { // Passado um objeto do tipo Game, ou seja, objeto de uma Entity
        /* 
         * Como não há ambiguidade (variáveis de nomes iguais, passadas como parâmetro), 
         * não é necessário utilizar o 'this'
         */
        id = entity.getId(); // Atribui o valor do id da Entity ao atributo da DTO
        title = entity.getTitle(); // Atribui o valor do title da Entity ao atributo da DTO
        year = entity.getYear(); // Atribui o valor do year da Entity ao atributo da DTO
        imgUrl = entity.getImgUrl(); // Atribui o valor da imgUrl da Entity ao atributo da DTO
        shortDescription = entity.getShortDescription(); // Atribui o valor do shortDescription da Entity ao atributo da DTO
    }

    /*
     * Não é necessário utilizar os métodos set em uma classe DTO,
     * pois seus atributos serão originados das classes Entities
     */

    public Long getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }
    
    public String getShortDescription() {
        return shortDescription;
    }
    
}