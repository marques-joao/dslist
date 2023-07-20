package com.joaomarques.dslist.Projections;

public interface GameMinProjection {
    
    // Métodos que retornam os dados da query feita na GameRepository

    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
    
}