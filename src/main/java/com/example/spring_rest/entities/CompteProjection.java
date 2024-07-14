package com.example.spring_rest.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1",types=Compte.class)
public interface CompteProjection {
    public double getSolde();
    public String getEtat();

}
