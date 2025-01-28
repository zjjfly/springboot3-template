package com.github.zjjfly.template.controller;

import com.github.zjjfly.template.dto.Response;
import com.github.zjjfly.template.model.Person;
import com.github.zjjfly.template.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author <a href="https://github.com/zjjfly"/>zjjfly</a>
 */
@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping
    public Response<List<Person>> search() {
        List<Person> all = personRepository.findAll(Map.of("name_eq", "foo",
                        "age_lte", "18"), Person.class);
        return Response.success(all);
    }

    @PostMapping
    public Response<Person> save() {
        Person person = new Person("foo",19);
        return Response.success(personRepository.save(person));
    }

    @DeleteMapping("/{id}")
    public Response<Void> deleteById(@PathVariable UUID id) {
        personRepository.deleteById(id);
        return Response.success();
    }


}
