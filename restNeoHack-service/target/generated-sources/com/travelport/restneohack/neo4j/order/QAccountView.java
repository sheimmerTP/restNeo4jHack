package com.travelport.restneohack.neo4j.order;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAccountView is a Querydsl query type for AccountView
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAccountView extends EntityPathBase<AccountView> {

    private static final long serialVersionUID = -316563005;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QAccountView accountView = new QAccountView("accountView");

    public final com.travelport.restneohack.neo4j.core.QAbstractEntity _super = new com.travelport.restneohack.neo4j.core.QAbstractEntity(this);

    public final com.travelport.restneohack.neo4j.core.QAddress billingAddress;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SetPath<PaymentType, SimplePath<PaymentType>> lineItems = this.<PaymentType, SimplePath<PaymentType>>createSet("lineItems", PaymentType.class, SimplePath.class, PathInits.DIRECT);

    public final com.travelport.restneohack.neo4j.core.QAddress shippingAddress;

    public final com.travelport.restneohack.neo4j.core.QTraveler traveler;

    public QAccountView(String variable) {
        this(AccountView.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QAccountView(Path<? extends AccountView> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAccountView(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAccountView(PathMetadata<?> metadata, PathInits inits) {
        this(AccountView.class, metadata, inits);
    }

    public QAccountView(Class<? extends AccountView> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.billingAddress = inits.isInitialized("billingAddress") ? new com.travelport.restneohack.neo4j.core.QAddress(forProperty("billingAddress"), inits.get("billingAddress")) : null;
        this.shippingAddress = inits.isInitialized("shippingAddress") ? new com.travelport.restneohack.neo4j.core.QAddress(forProperty("shippingAddress"), inits.get("shippingAddress")) : null;
        this.traveler = inits.isInitialized("traveler") ? new com.travelport.restneohack.neo4j.core.QTraveler(forProperty("traveler")) : null;
    }

}

