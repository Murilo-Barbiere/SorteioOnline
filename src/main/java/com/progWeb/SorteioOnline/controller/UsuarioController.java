package com.progWeb.SorteioOnline.controller;

import com.progWeb.SorteioOnline.DTO.Response.UsuarioResposeDTO;
import com.progWeb.SorteioOnline.model.UsuarioModel;
import com.progWeb.SorteioOnline.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioResposeDTO> listaUsuarios(){
        return usuarioService.getAll();
    }

    @GetMapping("/{id}")
    public UsuarioResposeDTO mostraUsuario(@PathVariable Long id){
        return usuarioService.getUser(id).orElseThrow(() -> new RuntimeException("erro"));
    }
}
