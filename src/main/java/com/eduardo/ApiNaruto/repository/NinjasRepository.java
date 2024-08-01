package com.eduardo.ApiNaruto.repository;

import com.eduardo.ApiNaruto.model.Ninjas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjasRepository extends JpaRepository<Ninjas, Long> {
}
