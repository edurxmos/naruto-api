package com.eduardo.ApiNaruto.controller;

import com.eduardo.ApiNaruto.service.NinjasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ninjas")
public class NinjasController {

    @Autowired
    private NinjasService service;

}