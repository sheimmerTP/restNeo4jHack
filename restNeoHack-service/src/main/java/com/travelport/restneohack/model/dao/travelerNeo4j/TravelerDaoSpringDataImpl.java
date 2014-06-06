/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.travelport.restneohack.model.dao.travelerNeo4j;


import com.travelport.restneohack.neo4j.core.Address;
import com.travelport.restneohack.neo4j.core.EmailAddress;
import com.travelport.restneohack.neo4j.core.Traveler;
import com.travelport.restneohack.neo4j.core.TravelerRepository;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import static org.neo4j.graphdb.DynamicRelationshipType.withName;
import org.neo4j.graphdb.GraphDatabaseService;

import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.neo4j.kernel.impl.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sheimmer
 */


@Service
@Transactional
public class TravelerDaoSpringDataImpl {    
    
    @Autowired
    TravelerRepository travelerRepository;
    
    @Autowired
    GraphDatabase graphDatabase;
    
/*    public Traveler createTraveler(String firstName, String lastName, String emailAddress){
        
    Traveler traveler = new Traveler(firstName, lastName, emailAddress);    
    
    Transaction tx = graphDatabase.beginTx();
    
    try{
        travelerRepository.save(traveler);
        
        //what relationships are we assigning here?
        //assign address to traveler, but address has to be created and passed in as well
        
        tx.success();

        }finally {
            tx.finish();
        }
        
        //quicker way return TravelerRepository.save(new Traveler(firstName, lastName, emailAddress));
}*/ 
    @Transactional
    public Traveler addAddress(Address address, Traveler traveler){
        
        String travEMail= traveler.getEmailAddress();
 //       traveler = findByEmailAddress(travEMail);
        traveler.add(address);
        return travelerRepository.save(traveler);
        
    }
                
    @Transactional
    public Traveler createTraveler(Traveler traveler){
        //return travelerRepository.save(new Traveler(firstName, lastName, emailAddress));
        System.out.println("Traveler = " + traveler.toString());
        String firstName=traveler.getFirstName();
        String lastName = traveler.getLastName();
        String emailAddress = traveler.getEmailAddress();
    //    return worldRepository.save(new World(name, moons));
        return travelerRepository.save(new Traveler(firstName, lastName, emailAddress));
                //return travelerRepository.save(traveler);

    }
    
    public Traveler findOne(Long id){
        return travelerRepository.findOne(id);
    }
    
 //   public Traveler findByEmailAddress(String emailAddress){
   //     return travelerRepository.findByEmailAddress(emailAddress);
    //}
    
    public <T extends Traveler> T save(T traveler) {
        return travelerRepository.save(traveler);
    }
    
//    @Override
//    public EndResult<T> query(String string, Map<String, Object> map) {
//        return null;
//    }
}
