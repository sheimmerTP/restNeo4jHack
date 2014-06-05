package com.travelport.restneohack.neo4j.core;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QFormOfPayment is a Querydsl query type for FormOfPayment
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFormOfPayment extends EntityPathBase<FormOfPayment> {

    private static final long serialVersionUID = -141512789;

    public static final QFormOfPayment formOfPayment = new QFormOfPayment("formOfPayment");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final SimplePath<org.springframework.data.neo4j.fieldaccess.DynamicProperties> attributes = createSimple("attributes", org.springframework.data.neo4j.fieldaccess.DynamicProperties.class);

    public final StringPath description = createString("description");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final SetPath<Tag, QTag> tags = this.<Tag, QTag>createSet("tags", Tag.class, QTag.class, PathInits.DIRECT);

    public QFormOfPayment(String variable) {
        super(FormOfPayment.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QFormOfPayment(Path<? extends FormOfPayment> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QFormOfPayment(PathMetadata<?> metadata) {
        super(FormOfPayment.class, metadata);
    }

}

