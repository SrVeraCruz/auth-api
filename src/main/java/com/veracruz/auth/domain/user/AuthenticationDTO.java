package com.veracruz.auth.domain.user;

import jakarta.validation.constraints.NotNull;

public record AuthenticationDTO(@NotNull String email, @NotNull String password) {
}
