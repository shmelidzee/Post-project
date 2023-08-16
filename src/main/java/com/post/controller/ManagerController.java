package com.post.controller;

import com.post.command.RegisterParcelCommand;
import com.post.command.UpdateParcelCommand;
import com.post.dto.ParcelDTO;
import com.post.service.ManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post/manager")
@Tag(name = "Manager", description = "API for manager")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PutMapping("/parcel")
    @Operation(summary = "Update status parcel",
            description = "Update status parcel",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Update status parcel",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParcelDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            },
            tags = "Client")
    public ResponseEntity<ParcelDTO> updateStatusParcel(@RequestBody UpdateParcelCommand updateParcelCommand) {
        return ResponseEntity.ok(managerService.updateParcel(updateParcelCommand));
    }

    @PostMapping("/parcel")
    @Operation(summary = "Register parcel",
            description = "Register parcel",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Register parcel",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParcelDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            },
            tags = "Client")
    public ResponseEntity<ParcelDTO> registerParcel(@RequestBody RegisterParcelCommand registerParcelCommand) {
        return ResponseEntity.ok(managerService.registerParcel(registerParcelCommand));
    }
}