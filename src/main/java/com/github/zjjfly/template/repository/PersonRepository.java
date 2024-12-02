package com.github.zjjfly.template.repository;

import app.tozzi.repository.JPASearchRepository;
import com.github.zjjfly.template.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 */
public interface PersonRepository extends JpaRepository<Person, Long>, JPASearchRepository<Person> {
}
