package com.veracruz.auth.domain.user;

import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
    @NotNull String firstName,
    @NotNull String lastName,
    @NotNull String email,
    @NotNull String password,
    @NotNull UserRole role
) {
}
