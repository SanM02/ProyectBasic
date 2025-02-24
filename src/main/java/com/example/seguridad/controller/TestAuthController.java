package com.example.seguridad.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {

    @GetMapping("/hello")
    @PreAuthorize("permitAll()")
    public String hello() {
        return "Hello esta inseguro";
    }

    @GetMapping("/hello-seguro")
    @PreAuthorize("hasAuthority('READ')")
    public String helloSeguro() {
        return "Hello esta seguro";
    }

    @GetMapping("/hello-seguro2")
    @PreAuthorize("hasAuthority('CREATE')")
    public String helloSeguro2() {
        return "Hello esta seguro2";
    }
}
