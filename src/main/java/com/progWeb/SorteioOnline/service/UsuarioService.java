package com.progWeb.SorteioOnline.service;

import com.progWeb.SorteioOnline.DTO.Response.UsuarioResposeDTO;
import com.progWeb.SorteioOnline.model.UsuarioModel;
import com.progWeb.SorteioOnline.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioResposeDTO> getAll(){
        return usuarioRepository.findAllByUsuarioRespose();

    }

    public Optional<UsuarioResposeDTO> getUser(Long id){
        return usuarioRepository.findByUsuarioRespose(id);
    }
}
