package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.projections.ProductMinProjection;

public class ProductMinDTO {


    // Atributos de classe
    private String name;


    // Construtores
    public ProductMinDTO(){

    }

    public ProductMinDTO(String name){
        this.name = name;
    }

    public ProductMinDTO(ProductMinProjection projection){
        name = projection.getName();
    }


    // Getters
    public String getName() {
        return name;
    }

    // ToString
    @Override
    public String toString() {
        return "ProductMinDTO { " +
                "name = '" + name + '\'' +
                '}';
    }
}
