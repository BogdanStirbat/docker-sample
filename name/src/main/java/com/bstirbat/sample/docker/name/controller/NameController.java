package com.bstirbat.sample.docker.name.controller;

import com.bstirbat.sample.docker.name.entity.Name;
import com.bstirbat.sample.docker.name.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NameController {

    @Autowired
    private NameRepository nameRepository;

    @GetMapping("/name/{id}")
    @ResponseBody
    public Name findById(@PathVariable Long id) {

        return nameRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find a name with id: " + id));
    }

    @PostMapping("/name")
    @ResponseBody
    public Name addName(@RequestBody Name name) {

        return nameRepository.save(name);
    }
}
