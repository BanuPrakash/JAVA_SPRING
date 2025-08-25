package com.adobe.vehiclerental.security.dto;


import com.adobe.vehiclerental.security.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SignUpRequest {
    private String email;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();
}
