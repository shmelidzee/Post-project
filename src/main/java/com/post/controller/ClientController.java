package com.post.controller;

import com.post.dto.HistoryParcelDTO;
import com.post.dto.ParcelDTO;
import com.post.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post/client")
@Tag(name = "Client", description = "API for client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/parcel")
    @Operation(summary = "Get info about parcel",
            description = "Get info about parcel",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Get info about parcel",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParcelDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            },
            tags = "Client")
    public ResponseEntity<ParcelDTO> getParcel(@RequestParam(value = "id") Long id) {
        return ResponseEntity.ok(clientService.getParcel(id));
    }

    @GetMapping("/parcel/history")
    @Operation(summary = "Get history about parcel",
            description = "Get history about parcel",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Get history about parcel",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = HistoryParcelDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            },
            tags = "Client")
    public ResponseEntity<List<HistoryParcelDTO>> getHistoryParcel(@RequestParam(value = "id") Long id) {
        return ResponseEntity.ok(clientService.getHistory(id));
    }

    @PutMapping("/parcel/take")
    @Operation(summary = "Take parcel",
            description = "Take parcel",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Take parcel",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParcelDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            },
            tags = "Client")
    public ResponseEntity<ParcelDTO> takeParcel(@RequestParam(value = "id") Long id,
                                                @RequestParam(value = "name") String name) {
        return ResponseEntity.ok(clientService.takeParcel(id, name));
    }
}