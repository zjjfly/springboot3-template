package com.github.zjjfly.template.model;

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

    private String name;

    private Integer age;

}
