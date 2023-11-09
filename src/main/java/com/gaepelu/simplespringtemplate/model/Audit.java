package com.gaepelu.simplespringtemplate.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;

@Data
@Getter
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit {
    @Column(updatable = false)
    @CreatedBy
    private String userInsert;

    @LastModifiedBy
    private String userUpdate;

    @Column(updatable = false)
    @CreationTimestamp
    private ZonedDateTime insertDatetime;

    @UpdateTimestamp
    private ZonedDateTime updateDatetime;
}
