package com.travelport.restneohack.neo4j.core;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCountry is a Querydsl query type for Country
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCountry extends EntityPathBase<Country> {

    private static final long serialVersionUID = 569471862;

    public static final QCountry country = new QCountry("country");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final StringPath code = createString("code");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public QCountry(String variable) {
        super(Country.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QCountry(Path<? extends Country> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QCountry(PathMetadata<?> metadata) {
        super(Country.class, metadata);
    }

}

