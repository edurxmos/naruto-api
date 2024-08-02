package com.eduardo.ApiNaruto.controller;

import com.eduardo.ApiNaruto.model.Ninjas;
import com.eduardo.ApiNaruto.service.NinjasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Ninjas> optionalNinja = service.findNinjaById(id);
        if (optionalNinja.isPresent()) {
            return ResponseEntity.ok(optionalNinja.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado. Passe um id válido");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNinja(@PathVariable Long id) {
        service.deleteNinja(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ninjas> updateNinja(@PathVariable Long id, @RequestBody Ninjas ninja) {
        Ninjas updateNinjaResult = service.updateNinja(id, ninja);

        try {
            return new ResponseEntity<>(updateNinjaResult, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

}
