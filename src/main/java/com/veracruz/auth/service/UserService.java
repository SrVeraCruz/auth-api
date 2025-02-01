package com.veracruz.auth.service;

import com.veracruz.auth.domain.category.Category;
import com.veracruz.auth.domain.category.CategoryRequestDTO;
import com.veracruz.auth.domain.category.CategoryResponseDTO;
import com.veracruz.auth.domain.user.RegisterDTO;
import com.veracruz.auth.domain.user.User;
import com.veracruz.auth.domain.user.UserResponseDTO;
import com.veracruz.auth.domain.user.exceptions.UserAlreadExistException;
import com.veracruz.auth.repositories.CategoryRepository;
import com.veracruz.auth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<UserResponseDTO> findAll() {
        List<User> users = this.repository.findAll();

        return users.stream().map(user -> new UserResponseDTO(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getRole(),
            user.getCreatedAt()
        )).toList();
    }

    public Optional<UserResponseDTO> findById(UUID id) {
        return this.repository.findById(id)
            .map(user -> new UserResponseDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt()
            )
        );
    }

    public UserResponseDTO register(RegisterDTO data) {
            if(this.repository.findByEmail(data.email()) != null) throw new UserAlreadExistException();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User newUser = new User(
            data.firstName(), data.lastName(),
            data.email(), encryptedPassword,
            data.role()
        );

        this.repository.save(newUser);

        return new UserResponseDTO(
            newUser.getId(),
            newUser.getFirstName(),
            newUser.getLastName(),
            newUser.getEmail(),
            newUser.getRole(),
            newUser.getCreatedAt()
        );
    }
}