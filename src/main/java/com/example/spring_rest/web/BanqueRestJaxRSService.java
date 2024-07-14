package com.example.spring_rest.web;

import com.example.spring_rest.entities.Compte;
import com.example.spring_rest.repository.CompteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/jaxrs")
public class BanqueRestJaxRSService {
    @Autowired
    private CompteRepository compteRepository;
    @Path("/comptes") @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Compte>listComptes(){
        return compteRepository.findAll();
    }
    @Path("/comptes/{code}") @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Compte findCompte(@PathParam("code") Long code){
        return compteRepository.findById(code).get();
    }
    @Path("/comptes") @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Compte save(Compte cpt)
    {
        return compteRepository.save(cpt);
    }
    @Path("/comptes/{code}") @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Compte update(@PathParam("code") Long code,Compte cp){
        cp.setCode(code);
        return compteRepository.save(cp);
    }
    @Path("/comptes/{code}") @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("code") Long code)
    {
        compteRepository.deleteById(code);
    }

}
