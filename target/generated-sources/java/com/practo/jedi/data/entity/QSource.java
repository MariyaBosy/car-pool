package com.practo.jedi.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSource is a Querydsl query type for Source
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSource extends EntityPathBase<Source> {

    private static final long serialVersionUID = -896085170L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSource source = new QSource("source");

    public final QAddress address;

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final DateTimePath<java.util.Date> deletedAt = createDateTime("deletedAt", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final SetPath<Listing, QListing> listings = this.<Listing, QListing>createSet("listings", Listing.class, QListing.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> modifiedAt = createDateTime("modifiedAt", java.util.Date.class);

    public final StringPath name = createString("name");

    public QSource(String variable) {
        this(Source.class, forVariable(variable), INITS);
    }

    public QSource(Path<? extends Source> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSource(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSource(PathMetadata metadata, PathInits inits) {
        this(Source.class, metadata, inits);
    }

    public QSource(Class<? extends Source> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
    }

}

