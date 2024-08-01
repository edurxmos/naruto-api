package com.eduardo.ApiNaruto.service;

import com.eduardo.ApiNaruto.model.Ninjas;
import com.eduardo.ApiNaruto.repository.NinjasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjasService {

    @Autowired
    private NinjasRepository repository;

    // cria um novo ninja e insere no banco de dados
    public Ninjas createNinja(Ninjas ninja) {
        return repository.save(ninja);
    }

    // ver todos os ninjas
    // faz uma consulta no banco de dados e devolve uma lista de ninjas
    public List<Ninjas> getAllNinjas() {
        return repository.findAll();
    }

    // deleter um ninja por id
    public void deleteNinja(Long id) {
        repository.deleteById(id);
    }

}
