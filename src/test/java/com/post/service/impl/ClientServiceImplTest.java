package com.post.service.impl;

import com.post.domain.entities.History;
import com.post.domain.entities.Parcel;
import com.post.domain.enums.ParcelStatus;
import com.post.domain.enums.ParcelType;
import com.post.repository.HistoryRepository;
import com.post.repository.ParcelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    HistoryRepository historyRepository;
    @Mock
    ParcelRepository parcelRepository;

    @InjectMocks
    ClientServiceImpl clientService;

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

    @Test
    void should_get_parcel() {
        when(parcelRepository.getReferenceById(1L)).thenReturn(parcel);

        assertEquals(ParcelType.LETTER, clientService.getParcel(1L).getType());
        assertEquals(1L, clientService.getParcel(1L).getId());
        assertEquals("220879", clientService.getParcel(1L).getIndex());
    }

    @Test
    void should_take_parcel() {
        when(parcelRepository.getReferenceById(1L)).thenReturn(parcel);

        assertEquals(ParcelType.LETTER, clientService.getParcel(1L).getType());
        assertEquals(1L, clientService.getParcel(1L).getId());
    }

    @Test
    void should_get_history(){
        when(historyRepository.getHistoriesByParcelId(1L)).thenReturn(List.of(history));

        assertEquals(ParcelStatus.DECORATED.getValue(), clientService.getHistory(1L).get(0).getStatus());
        assertEquals(parcel.getId(), clientService.getHistory(1L).get(0).getParcelId());
        assertEquals(1, clientService.getHistory(1L).size());
    }
}