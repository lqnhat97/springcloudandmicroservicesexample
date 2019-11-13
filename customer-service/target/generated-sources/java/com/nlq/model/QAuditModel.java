package com.nlq.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditModel is a Querydsl query type for AuditModel
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAuditModel extends EntityPathBase<AuditModel> {

    private static final long serialVersionUID = -382824325L;

    public static final QAuditModel auditModel = new QAuditModel("auditModel");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QAuditModel(String variable) {
        super(AuditModel.class, forVariable(variable));
    }

    public QAuditModel(Path<? extends AuditModel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditModel(PathMetadata metadata) {
        super(AuditModel.class, metadata);
    }

}

