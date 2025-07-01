package com.growit.app.sample.infrastructure.persistence.sample.source.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSampleEntity is a Querydsl query type for SampleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSampleEntity extends EntityPathBase<SampleEntity> {

    private static final long serialVersionUID = -1075718813L;

    public static final QSampleEntity sampleEntity = new QSampleEntity("sampleEntity");

    public final com.growit.app.common.entity.QBaseEntity _super = new com.growit.app.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final StringPath email = createString("email");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath uid = createString("uid");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath userId = createString("userId");

    public QSampleEntity(String variable) {
        super(SampleEntity.class, forVariable(variable));
    }

    public QSampleEntity(Path<? extends SampleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSampleEntity(PathMetadata metadata) {
        super(SampleEntity.class, metadata);
    }

}

