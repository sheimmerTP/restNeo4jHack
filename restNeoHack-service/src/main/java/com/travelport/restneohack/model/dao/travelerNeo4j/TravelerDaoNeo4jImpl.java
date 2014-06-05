/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.travelport.restneohack.model.dao.travelerNeo4j;

import com.travelport.restneohack.model.dao.GraphUtil;
import static com.travelport.restneohack.model.dao.GraphUtil.registerShutdownHook;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.Index;
import com.travelport.restneohack.neo4j.core.Traveler;
import org.neo4j.helpers.collection.IteratorUtil;

/**
 *
 * @author sheimmer
 */
public class TravelerDaoNeo4jImpl {
    
        private static final String DB_PATH = "target/java-query-db";
        String resultString;
        String columnsString;
        String nodeResult;
        String rows = "";
        
    
    public Node createTraveler(Traveler traveler){
        
        GraphUtil.clearDbPath(DB_PATH);
        
        GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );
        registerShutdownHook(db);
        

        
        
        Transaction tx = db.beginTx();
        try {
            Node travelerNode = db.createNode();

            tx.success();
            return travelerNode;
        } finally {
            tx.finish();
            db.shutdown();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    /**
     * Default behavior: Searches for the givenName and surName of traveler
     * @param traveler
     * @return traveler associations
     */
     public Traveler readTraveler(Traveler traveler){
         
        GraphUtil.clearDbPath(DB_PATH);
        
        GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );
        Index<Node> nodeIndex = db.index().forNodes("nodes");

        
        //try{
//            System.out.println("searching for traveler " + travGivenName);
//            Node Traveler = nodeIndex.get("givenName", travGivenName).getSingle();
//            System.out.println("The name of the user with id=2 is: "
//					+ user.getProperty("name"));
 
            System.out.println("searching for user with name=Peter..");
            Node user2 = nodeIndex.get("name", "Peter").getSingle();
            System.out.println("The id of the user with name=Peter is: "
					+ user2.getProperty("id"));
            return traveler;
        //}
    }
    
    
     public Traveler updateTraveler(Traveler traveler){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
      public Traveler deleteTraveler(Traveler traveler){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
