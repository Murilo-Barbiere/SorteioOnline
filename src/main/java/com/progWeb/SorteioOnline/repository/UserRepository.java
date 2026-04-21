package com.progWeb.SorteioOnline.repository;

import com.progWeb.SorteioOnline.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserDetails> findUserByEmail(String username);
}