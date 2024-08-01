package com.eduardo.ApiNaruto.service;

import com.eduardo.ApiNaruto.model.Ninjas;
import com.eduardo.ApiNaruto.repository.NinjasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NinjasService {

    @Autowired
    private NinjasRepository repository;

    // criar um novo ninja
    public Ninjas createNinja(Ninjas ninja) {
        return repository.save(ninja);
    }

}
