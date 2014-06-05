package com.travelport.restneohack.neo4j.core;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = 896277790;

    public static final QCategory category = new QCategory("category");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final SetPath<Category, QCategory> children = this.<Category, QCategory>createSet("children", Category.class, QCategory.class, PathInits.DIRECT);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public QCategory(String variable) {
        super(Category.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QCategory(Path<? extends Category> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata<?> metadata) {
        super(Category.class, metadata);
    }

}

