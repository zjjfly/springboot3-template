package com.github.zjjfly.template.model;

import app.tozzi.annotation.Searchable;
import app.tozzi.model.JPASearchOperatorFilter;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 */
@Entity(name = "person")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person extends BaseEntity<UUID, String> {


    @Searchable(allowedFilters = {JPASearchOperatorFilter.EQ, JPASearchOperatorFilter.CONTAINS})
    private String name;

    @Searchable(allowedFilters = {JPASearchOperatorFilter.BETWEEN, JPASearchOperatorFilter.GTE, JPASearchOperatorFilter.LTE})
    private Integer age;

}
