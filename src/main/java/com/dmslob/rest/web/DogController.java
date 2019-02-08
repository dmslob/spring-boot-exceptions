package com.dmslob.rest.web;

import com.dmslob.rest.model.DogDto;
import com.dmslob.rest.repo.Dog;
import com.dmslob.rest.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private DogService service;

    @GetMapping
    public List<Dog> getDogs() {
        return service.getDogs();
    }

    @PostMapping
    public void add(@RequestBody DogDto dto) {
        service.add(dto);
    }

    @GetMapping("/{id}")
    public Dog getById(@PathVariable(required = true) long id) {
//        try {
//            return service.getDogById(id);
//        } catch (DogsNotFoundException ex) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Actor Not Found", ex);
//        }
        return service.getDogById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
}