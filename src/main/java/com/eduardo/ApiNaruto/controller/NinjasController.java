package com.eduardo.ApiNaruto.controller;

import com.eduardo.ApiNaruto.model.Ninjas;
import com.eduardo.ApiNaruto.service.NinjasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<Ninjas>> getAllNinjas() {
        List<Ninjas> allNinjas = service.getAllNinjas();
        return new ResponseEntity<>(allNinjas, HttpStatus.OK);
    }

}
