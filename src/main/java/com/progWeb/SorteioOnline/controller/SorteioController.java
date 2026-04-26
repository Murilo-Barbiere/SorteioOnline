package com.progWeb.SorteioOnline.controller;

import com.progWeb.SorteioOnline.model.SorteioModel;
import com.progWeb.SorteioOnline.service.SorteioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/sorteio")
public class SorteioController {

    private SorteioService sorteioService;

    public SorteioController(SorteioService sorteioService) {
        this.sorteioService = sorteioService;
    }

    @PostMapping
    public ResponseEntity<SorteioModel> criaNovoSorteio(@RequestBody SorteioModel sorteio){
        SorteioModel novoSortei = sorteioService.addSorteio(sorteio);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoSortei);
    }
}
