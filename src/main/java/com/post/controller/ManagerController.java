package com.post.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post/manager")
@Tag(name = "Manager", description = "API for manager")
public class ManagerController {

    @GetMapping
    public ResponseEntity<Boolean> getAllParcels() {
        return ResponseEntity.ok(true);
    }
}