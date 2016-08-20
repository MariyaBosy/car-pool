package com.practo.jedi.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAddress is a Querydsl query type for Address
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAddress extends EntityPathBase<Address> {

    private static final long serialVersionUID = -1134651615L;

    public static final QAddress address = new QAddress("address");

    public final StringPath administrativeAreaLevel1 = createString("administrativeAreaLevel1");

    public final StringPath administrativeAreaLevel2 = createString("administrativeAreaLevel2");

    public final StringPath country = createString("country");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final DateTimePath<java.util.Date> deletedAt = createDateTime("deletedAt", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final NumberPath<java.math.BigDecimal> latitude = createNumber("latitude", java.math.BigDecimal.class);

    public final SetPath<Listing, QListing> listings = this.<Listing, QListing>createSet("listings", Listing.class, QListing.class, PathInits.DIRECT2);

    public final NumberPath<java.math.BigDecimal> longitude = createNumber("longitude", java.math.BigDecimal.class);

    public final DateTimePath<java.util.Date> modifiedAt = createDateTime("modifiedAt", java.util.Date.class);

    public final StringPath neighborhood = createString("neighborhood");

    public final StringPath postalCode = createString("postalCode");

    public final StringPath route = createString("route");

    public final SetPath<Source, QSource> sources = this.<Source, QSource>createSet("sources", Source.class, QSource.class, PathInits.DIRECT2);

    public final StringPath streetNumber = createString("streetNumber");

    public final StringPath sublocality = createString("sublocality");

    public QAddress(String variable) {
        super(Address.class, forVariable(variable));
    }

    public QAddress(Path<? extends Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddress(PathMetadata metadata) {
        super(Address.class, metadata);
    }

}

