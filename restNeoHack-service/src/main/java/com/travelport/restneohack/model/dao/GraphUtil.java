/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.travelport.restneohack.model.dao;

import java.io.File;
import java.io.IOException;
import org.neo4j.graphdb.GraphDatabaseService;
import static org.neo4j.kernel.impl.util.FileUtils.deleteRecursively;

/**
 *
 * @author sheimmer
 */
public class GraphUtil {

    public static void clearDbPath(String DB_PATH) {
        try {
                deleteRecursively( new File( DB_PATH ) );
            }
        catch ( IOException e )
            {
                throw new RuntimeException( e );
            }    
        }
    
    public static void registerShutdownHook(final GraphDatabaseService graphDb) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				graphDb.shutdown();
			}
		});
	}
    
    
}
