package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.porjections.MovieMinProjection;

public class MovieMinDTO {

    // Atributos de classe
    private Long id;
    private String name;


    // Construtores
    public MovieMinDTO(){

    }
    public MovieMinDTO(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public MovieMinDTO(MovieMinProjection projection){
        id = projection.getId();
        name = projection.getName();
    }



    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // ToString
    @Override
    public String toString() {
        return "MovieDTO { " +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }
}
