package com.petdoc.user;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UService userService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public String login(@RequestBody UDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userService.loadUserByUsername(loginDto.getEmail());
        return jwtTokenUtil.generateToken(userDetails);
    }

    @PostMapping("/register")
    public String registerUser(@Valid @RequestBody UDto registrationDto) {
        if (userService.existsByEmail(registrationDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        UUser user = new UUser();
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setName(registrationDto.getName());
        userService.saveUser(user);
        return "User registered successfully";
    }

    @PostMapping("/refresh")
    public String refresh(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7);
        if (jwtTokenUtil.canTokenBeRefreshed(token)) {
            return jwtTokenUtil.refreshToken(token);
        } else {
            throw new RuntimeException("Token can't be refreshed");
        }
    }

    @GetMapping("/ping")
    public String ping() {
        return "Pong";
    }
}
