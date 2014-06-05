package com.travelport.restneohack.neo4j.core;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAbstractEntity is a Querydsl query type for AbstractEntity
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QAbstractEntity extends BeanPath<AbstractEntity> {

    private static final long serialVersionUID = 1498769093;

    public static final QAbstractEntity abstractEntity = new QAbstractEntity("abstractEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QAbstractEntity(String variable) {
        super(AbstractEntity.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QAbstractEntity(Path<? extends AbstractEntity> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QAbstractEntity(PathMetadata<?> metadata) {
        super(AbstractEntity.class, metadata);
    }

}

