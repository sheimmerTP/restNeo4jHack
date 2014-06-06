/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.travelport.restneohack.neo4j.dao;

import com.travelport.restneohack.model.dao.travelerNeo4j.TravelerDaoSpringDataImpl;
import com.travelport.restneohack.neo4j.AbstractIntegrationTest;
import com.travelport.restneohack.neo4j.core.Address;
import com.travelport.restneohack.neo4j.core.Country;
import com.travelport.restneohack.neo4j.core.EmailAddress;
import com.travelport.restneohack.neo4j.core.Traveler;
import com.travelport.restneohack.neo4j.core.TravelerRepository;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sheimmer
 */

public class TravelerDaoSpringDataImplTest extends AbstractIntegrationTest{
    
        @Autowired
	TravelerRepository repository;
        
        @Autowired
        TravelerDaoSpringDataImpl dataImpl;
    
    @Test
    public void savesTravelerCorrectly(){
   //     TravelerDaoSpringDataImpl impl = new TravelerDaoSpringDataImpl();
        EmailAddress email = new EmailAddress("HanSolo@travelport.com");
        Traveler hanSolo = new Traveler("Han", "Solo", email.getEmail());
        
        Country usa=new Country("US","United States");
        hanSolo.add(new Address("27 Broadway", "New York", usa));
        //Traveler result = repository.save(hanSolo);
        Traveler result = dataImpl.createTraveler(hanSolo);
        result.toString();
        
        
	assertThat(result.getId(), is(notNullValue()));
        
        
        
  //      Traveler hanny = impl.findByEmailAddress(email.getEmail());
        Traveler result2 = repository.findByEmailAddress(email.getEmail());
        System.out.println("Traveler email = " + hanSolo.getEmailAddress());
        System.out.println("Traveler = " + hanSolo.toString());
 //       assertThat(result, is(hanSolo));
    }
    


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}