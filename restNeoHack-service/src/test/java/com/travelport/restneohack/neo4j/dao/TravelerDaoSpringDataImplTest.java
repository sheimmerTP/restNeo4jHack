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
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.is;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sheimmer
 */
@ContextConfiguration(locations = "classpath:/META_INF.spring/ApplicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TravelerDaoSpringDataImplTest extends AbstractIntegrationTest {
    
    @Autowired
    TravelerDaoSpringDataImpl travelerDao;
    
    public TravelerDaoSpringDataImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void savesTravelerCorrectly(){
        TravelerDaoSpringDataImpl impl = new TravelerDaoSpringDataImpl();
        EmailAddress email = new EmailAddress("HanSolo@travelport.com");
        Traveler hanSolo = new Traveler("Han", "Solo", email.getEmail());
        
        Country usa=new Country("US","United States");
        hanSolo.add(new Address("27 Broadway", "New York", usa));
        
        Traveler result = travelerDao.createTraveler(hanSolo);
        
        Traveler hanny = impl.findByEmailAddress(email.getEmail());
        System.out.println("Traveler = " + hanSolo.toString());
        assertThat(result, is(hanSolo));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}