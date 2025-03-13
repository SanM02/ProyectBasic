package com.example.seguridad.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('READ')")
    public String get() {
        return "GET";
    }

    @PostMapping("/post")
    public String post() {
        return "POST";
    }

    @PutMapping("/put")
    public String put() {
        return "PUT";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "DELETE";
    }

    @PatchMapping("/patch")
    @PreAuthorize("hasAuthority('REFACTOR')")
    public String patch() {
        return "PATCH";
    }
}
