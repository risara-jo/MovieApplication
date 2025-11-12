package com.example.MovieApplication.Controller;

import com.example.MovieApplication.DTO.LoginRequestDTO;
import com.example.MovieApplication.DTO.LoginResponseDTO;
import com.example.MovieApplication.DTO.RegisterRequestDTO;
import com.example.MovieApplication.Entity.User;
import com.example.MovieApplication.Repository.UserRepository;
import com.example.MovieApplication.Service.AuthenticationService;
import com.example.MovieApplication.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registernormaluser")
    public ResponseEntity<User> registerNormalUser(@Valid @RequestBody RegisterRequestDTO registerRequestDTO){

        return ResponseEntity.ok(authenticationService.registerNormalUser(registerRequestDTO));
    }

    @PostMapping("/registeradminuser")
    public ResponseEntity<User> registerAdminUser(@Valid @RequestBody RegisterRequestDTO registerRequestDTO){

        return ResponseEntity.ok(authenticationService.registerAdminUser(registerRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO){

        return ResponseEntity.ok(authenticationService.login(loginRequestDTO));
    }

    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> getCurrentUser(Authentication authentication) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Map<String, Object> userDTO = new HashMap<>();
        userDTO.put("id", user.getId());
        userDTO.put("username", user.getUsername());
        userDTO.put("email", user.getEmail());
        userDTO.put("roles", user.getRoles());

        return ResponseEntity.ok(userDTO);
    }


}
