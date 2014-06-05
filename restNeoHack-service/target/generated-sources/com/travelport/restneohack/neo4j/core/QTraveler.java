package com.travelport.restneohack.neo4j.core;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTraveler is a Querydsl query type for Traveler
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTraveler extends EntityPathBase<Traveler> {

    private static final long serialVersionUID = 2133626215;

    public static final QTraveler traveler = new QTraveler("traveler");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final SetPath<Address, QAddress> addresses = this.<Address, QAddress>createSet("addresses", Address.class, QAddress.class, PathInits.DIRECT);

    public final StringPath emailAddress = createString("emailAddress");

    public final StringPath firstName = createString("firstName");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath lastName = createString("lastName");

    public QTraveler(String variable) {
        super(Traveler.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QTraveler(Path<? extends Traveler> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QTraveler(PathMetadata<?> metadata) {
        super(Traveler.class, metadata);
    }

}

