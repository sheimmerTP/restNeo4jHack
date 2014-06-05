package com.travelport.restneohack.neo4j.core;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * @author mh
 * @since 02.07.12
 */
@RelationshipEntity(type = "RATED")
public class Rating extends AbstractEntity {
    @StartNode
    private Traveler traveler;
    @EndNode
    private FormOfPayment formOfPayment;
    private int stars;
    private String comment;

    public Rating() {
    }

    public Rating(Traveler traveler, FormOfPayment formOfPayment, int stars, String comment) {
        this.traveler = traveler;
        this.formOfPayment = formOfPayment;
        this.stars = stars;
        this.comment = comment;
    }
}
