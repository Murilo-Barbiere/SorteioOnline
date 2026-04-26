package com.progWeb.SorteioOnline.service;

import com.progWeb.SorteioOnline.model.SorteioModel;
import com.progWeb.SorteioOnline.repository.SorteioRepository;
import org.springframework.stereotype.Service;

@Service
public class SorteioService {

    private SorteioRepository sorteioRepository;

    public SorteioService(SorteioRepository sorteioRepository) {
        this.sorteioRepository = sorteioRepository;
    }

    public SorteioModel addSorteio(SorteioModel sorteio){
        return sorteioRepository.save(sorteio);
    }
}
