package com.github.zjjfly.template.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SoftDelete;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@SoftDelete(columnName = "deleted")
public class BaseEntity<U> {

    @Version
    @Column(name = "version")
    protected Integer version;

    @CreatedBy
    @Column(name = "created_by", length = 50, updatable = false)
    protected U createdBy;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    protected Timestamp createdAt;

    @LastModifiedBy
    @Column(name = "updated_by")
    protected U updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    protected Timestamp updatedAt;

}
