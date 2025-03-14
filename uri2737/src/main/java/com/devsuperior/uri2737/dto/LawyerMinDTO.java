package com.devsuperior.uri2737.dto;

import com.devsuperior.uri2737.projections.LawyerMinProjection;

public class LawyerMinDTO {

    // Atributos de classe
    private String name;
    private Integer customersNumber;


    // Construtores
    public LawyerMinDTO() {
    }

    public LawyerMinDTO(String name, Integer customersNumber) {
        this.name = name;
        this.customersNumber = customersNumber;
    }

    public LawyerMinDTO(LawyerMinProjection projection) {
        name = projection.getName();
        customersNumber = projection.getCustomersNumber();
    }

    // Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCustomersNumber() {
        return customersNumber;
    }

    public void setCustomersNumber(Integer customersNumber) {
        this.customersNumber = customersNumber;
    }

    @Override
    public String toString() {
        return "Name = " + name + ", customersNumber = " + customersNumber;
    }
}
