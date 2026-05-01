package com.progWeb.SorteioOnline.service;

import com.progWeb.SorteioOnline.DTO.Response.LoginResponseDTO;
import com.progWeb.SorteioOnline.DTO.Response.RegisterResponseDTO;
import com.progWeb.SorteioOnline.DTO.request.LoginRequestDTO;
import com.progWeb.SorteioOnline.DTO.request.ResgisterRequestDTO;
import com.progWeb.SorteioOnline.config.TonkenConfig;
import com.progWeb.SorteioOnline.model.UsuarioModel;
import com.progWeb.SorteioOnline.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UsuarioRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private TonkenConfig tonkenConfig;

    public AuthService(UsuarioRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TonkenConfig tonkenConfig) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tonkenConfig = tonkenConfig;
    }

    public LoginResponseDTO validaUser(LoginRequestDTO request){
        UsernamePasswordAuthenticationToken userPass = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
        Authentication authentication = authenticationManager.authenticate(userPass);

        UsuarioModel user = (UsuarioModel) authentication.getPrincipal();
        String token = tonkenConfig.generateToken(user);
        return new LoginResponseDTO(token);
    }

    public RegisterResponseDTO newUser(ResgisterRequestDTO request){
        UsuarioModel user = new UsuarioModel();

        user.setNome(request.nome());
        user.setEmail(request.email());
        user.setSenha(passwordEncoder.encode(request.senha()));

        userRepository.save(user);

        return new RegisterResponseDTO(user.getNome(), user.getEmail());
    }
}
