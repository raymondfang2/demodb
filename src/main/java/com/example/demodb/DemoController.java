package com.example.demodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoController {

    DBRepostory repo;

    @Autowired
    public DemoController(DBRepostory repo) {
        this.repo = repo;
    }

    @GetMapping("/hello")
    String hello() {
        return "Hello";
    }

    @GetMapping("/student/{id}")
    Map<String, Object> find(@PathVariable int id)
    {
        return repo.getStudent(id);
    }
}
