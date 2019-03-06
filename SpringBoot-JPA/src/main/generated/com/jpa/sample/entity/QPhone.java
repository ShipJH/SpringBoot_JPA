package com.jpa.sample.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPhone is a Querydsl query type for Phone
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPhone extends EntityPathBase<Phone> {

    private static final long serialVersionUID = 850968903L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPhone phone = new QPhone("phone");

    public final QMember member;

    public final StringPath no = createString("no");

    public final NumberPath<Integer> seq = createNumber("seq", Integer.class);

    public QPhone(String variable) {
        this(Phone.class, forVariable(variable), INITS);
    }

    public QPhone(Path<? extends Phone> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPhone(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPhone(PathMetadata metadata, PathInits inits) {
        this(Phone.class, metadata, inits);
    }

    public QPhone(Class<? extends Phone> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

