package com.travelport.restneohack.neo4j.core;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTag is a Querydsl query type for Tag
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTag extends EntityPathBase<Tag> {

    private static final long serialVersionUID = 2063911802;

    public static final QTag tag = new QTag("tag");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final SimplePath<Object> value = createSimple("value", Object.class);

    public QTag(String variable) {
        super(Tag.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QTag(Path<? extends Tag> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QTag(PathMetadata<?> metadata) {
        super(Tag.class, metadata);
    }

}

