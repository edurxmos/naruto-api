package com.eduardo.ApiNaruto.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ninjas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ninjas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String aldeia;
    int idade;
    String elemento;
    String imgUrl;

}