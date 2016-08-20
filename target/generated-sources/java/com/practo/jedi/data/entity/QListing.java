package com.practo.jedi.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QListing is a Querydsl query type for Listing
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QListing extends EntityPathBase<Listing> {

    private static final long serialVersionUID = 195016113L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QListing listing = new QListing("listing");

    public final QAddress address;

    public final SetPath<Booking, QBooking> bookings = this.<Booking, QBooking>createSet("bookings", Booking.class, QBooking.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final DateTimePath<java.util.Date> deletedAt = createDateTime("deletedAt", java.util.Date.class);

    public final DateTimePath<java.util.Date> departureTime = createDateTime("departureTime", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final DateTimePath<java.util.Date> modifiedAt = createDateTime("modifiedAt", java.util.Date.class);

    public final NumberPath<Integer> seatsAvailable = createNumber("seatsAvailable", Integer.class);

    public final QSource source;

    public final QUser user;

    public final QVehicle vehicle;

    public QListing(String variable) {
        this(Listing.class, forVariable(variable), INITS);
    }

    public QListing(Path<? extends Listing> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QListing(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QListing(PathMetadata metadata, PathInits inits) {
        this(Listing.class, metadata, inits);
    }

    public QListing(Class<? extends Listing> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
        this.source = inits.isInitialized("source") ? new QSource(forProperty("source"), inits.get("source")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
        this.vehicle = inits.isInitialized("vehicle") ? new QVehicle(forProperty("vehicle"), inits.get("vehicle")) : null;
    }

}

