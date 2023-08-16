package com.post.service.impl;

import com.post.command.RegisterParcelCommand;
import com.post.command.UpdateParcelCommand;
import com.post.domain.entities.History;
import com.post.domain.entities.Parcel;
import com.post.domain.enums.ParcelStatus;
import com.post.domain.enums.ParcelType;
import com.post.repository.HistoryRepository;
import com.post.repository.ParcelRepository;
import com.post.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ManagerServiceImplTest {

    @Mock
    HistoryRepository historyRepository;
    @Mock
    PostRepository postRepository;
    @Mock
    ParcelRepository parcelRepository;
    @InjectMocks
    ManagerServiceImpl managerService;

    Parcel parcel = Parcel.builder()
            .id(1L)
            .addressRecipient("Test address")
            .nameRecipient("Test name")
            .indexRecipient("220879")
            .type(ParcelType.LETTER)
            .status(ParcelStatus.DECORATED)
            .build();

    History history = History.builder()
            .date(Instant.now())
            .parcel(parcel)
            .status(ParcelStatus.DECORATED)
            .build();

    RegisterParcelCommand registerParcelCommand = new RegisterParcelCommand(ParcelType.LETTER, "220087", "Test", "Test");

    UpdateParcelCommand updateParcelCommand = new UpdateParcelCommand(1L, ParcelStatus.DELIVERED);

    @Test
    void should_register_parcel() {
        assertEquals(ParcelType.LETTER, managerService.registerParcel(registerParcelCommand).getType());
        assertEquals("220087", managerService.registerParcel(registerParcelCommand).getIndex());
        assertEquals("Test", managerService.registerParcel(registerParcelCommand).getAddress());
    }

    @Test
    void should_update_parcel() {
        when(parcelRepository.getReferenceById(1L)).thenReturn(parcel);

        assertEquals(ParcelStatus.DELIVERED, managerService.updateParcel(updateParcelCommand).getStatus());
        assertEquals(ParcelType.LETTER, managerService.updateParcel(updateParcelCommand).getType());
    }
}