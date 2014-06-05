/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.travelport.restneohack.model.dao.travelerNeo4j;


import com.travelport.restneohack.neo4j.core.TravelerRepository;
import com.travelport.restneohack.neo4j.core.Traveler;
import com.travelport.restneohack.neo4j.core.Address;
import java.io.File;
import java.util.Map;

import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.neo4j.kernel.impl.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.transaction.annotation.Transactional;

import static org.neo4j.graphdb.DynamicRelationshipType.withName;
import org.springframework.data.neo4j.conversion.EndResult;

/**
 *
 * @author sheimmer
 */
//@EnableNeo4jRepositories
public abstract class TravelerDaoSpringDataImpl implements TravelerRepository {
    
    @Bean
    EmbeddedGraphDatabase graphDatabaseService(){
        return new EmbeddedGraphDatabase("accessingdataneo4j.db");
    }
    
    @Autowired
    private TravelerRepository travelerRepository;
    
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
        traveler = findByEmailAddress(travEMail);
        traveler.add(address);
        return travelerRepository.save(traveler);
        
    }
                
    @Transactional
    public Traveler createTraveler(Traveler traveler){
        //return travelerRepository.save(new Traveler(firstName, lastName, emailAddress));
        return travelerRepository.save(traveler);

    }
    
    @Override
    public Traveler findOne(Long id){
        return travelerRepository.findOne(id);
    }
    
    @Override
    public Traveler findByEmailAddress(String emailAddress){
        return travelerRepository.findByEmailAddress(emailAddress);
    }
    
    @Override
    public <T extends Traveler> T save(T traveler) {
        return travelerRepository.save(traveler);
    }
    
//    @Override
//    public EndResult<T> query(String string, Map<String, Object> map) {
//        return null;
//    }
}
