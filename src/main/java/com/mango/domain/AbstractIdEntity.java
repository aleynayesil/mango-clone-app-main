package com.mango.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class AbstractIdEntity {

    @Id
    @GeneratedValue(generator =  "uuid4")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID", updatable = false, nullable = false, columnDefinition = "CHAR(64)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID rowId;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

}
