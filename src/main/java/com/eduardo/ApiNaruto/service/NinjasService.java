package com.eduardo.ApiNaruto.service;

import com.eduardo.ApiNaruto.model.Ninjas;
import com.eduardo.ApiNaruto.repository.NinjasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // procurar um ninja por id
    public Optional<Ninjas> findNinjaById(Long id) {
        return repository.findById(id);
    }

    // deleter um ninja por id
    public void deleteNinja(Long id) {
        repository.deleteById(id);
    }

    // atualizar um ninja
    public Ninjas updateNinja(Long id, Ninjas ninja) {
        Optional<Ninjas> oldNinja = repository.findById(id);

        if (oldNinja.isPresent()) {
            Ninjas newNinja = oldNinja.get();

            newNinja.setNome(ninja.getNome());
            newNinja.setAldeia(ninja.getAldeia());
            newNinja.setElemento(ninja.getElemento());
            newNinja.setIdade(ninja.getIdade());
            newNinja.setImgUrl(ninja.getImgUrl());

            return repository.save(newNinja);
        } else {
            throw new RuntimeException("Ninja não encontrado com o id: " + id);
        }
    }

}
