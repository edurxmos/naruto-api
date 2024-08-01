package com.eduardo.ApiNaruto.controller;

import com.eduardo.ApiNaruto.model.Ninjas;
import com.eduardo.ApiNaruto.service.NinjasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ninjas")
public class NinjasController {

    @Autowired
    private NinjasService service;

    @PostMapping("/add")
    public ResponseEntity<Ninjas> addNinja(@RequestBody Ninjas ninja) {
        Ninjas newNinja = service.createNinja(ninja);
        return new ResponseEntity<>(newNinja, HttpStatus.CREATED);
    }

}
