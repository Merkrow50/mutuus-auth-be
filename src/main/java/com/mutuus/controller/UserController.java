package com.mutuus.controller;

import com.mutuus.auth.AuthenticationResponse;
import com.mutuus.auth.RegisterRequest;
import com.mutuus.config.JwtService;
import com.mutuus.dto.UserDTO;
import com.mutuus.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

  private final JwtService jwtService;
  private UserRepository repository;

  private ModelMapper modelMapper;


  @GetMapping("/me")
  public ResponseEntity<UserDTO> me(@NonNull HttpServletRequest request) {
    final String authHeader = request.getHeader("Authorization");
    final String jwt;
    final String userEmail;
    jwt = authHeader.substring(7);
    userEmail = jwtService.extractUsername(jwt);
    return ResponseEntity.ok(modelMapper.map(repository.findByEmail(userEmail), UserDTO.class));
  }

}
