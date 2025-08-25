package com.adobe.vehiclerental.security.repo;


import com.adobe.vehiclerental.security.entity.User;
import com.adobe.vehiclerental.security.service.UserDetailsServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
