package com.devsuperior.uri2602.dto;

import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerNameProjection;

public class CustomerNameDTO {

    // Atributos
    private String name;


    // Construtores
    public CustomerNameDTO() {

    }

    public CustomerNameDTO(String name) {
        this.name = name;
    }

    public CustomerNameDTO(Customer entity) {
        name = entity.getName();
    }

    public CustomerNameDTO(CustomerNameProjection projection) {
        name = projection.getName();
    }


    // Getters
    public String getName() {
        return name;
    }


    // ToString
    @Override
    public String toString() {
        return "CustomerNameDTO{ " +
                "name = '" + name + '\'' +
                '}';
    }
}
