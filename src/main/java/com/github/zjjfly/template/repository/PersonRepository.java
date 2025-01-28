package com.github.zjjfly.template.repository;

import app.tozzi.repository.JPASearchRepository;
import com.github.zjjfly.template.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 */
public interface PersonRepository extends JpaRepository<Person, UUID>, JPASearchRepository<Person> {
}
