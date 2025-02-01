package com.veracruz.auth.domain.user;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.UUID;

public record UserResponseDTO(
    UUID id,
    String firstName,
    String lastName,
    String email,
    UserRole role,
    Date createdAt
) { }
