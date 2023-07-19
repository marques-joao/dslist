package com.joaomarques.dslist.Projections;

public interface GameMinProjection {
    
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
    
}