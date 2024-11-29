package com.github.zjjfly.template.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SoftDelete;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 */
@MappedSuperclass
@Getter
@Setter
@ToString
@SoftDelete(columnName = "deleted")
public abstract class BaseEntity {

    @Version
    @Column(name = "version")
    protected Integer version;

}
