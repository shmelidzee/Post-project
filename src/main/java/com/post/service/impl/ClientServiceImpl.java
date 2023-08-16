package com.post.service.impl;

import com.post.domain.entities.History;
import com.post.domain.entities.Parcel;
import com.post.domain.enums.ParcelStatus;
import com.post.dto.HistoryParcelDTO;
import com.post.dto.ParcelDTO;
import com.post.repository.HistoryRepository;
import com.post.repository.ParcelRepository;
import com.post.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ParcelRepository parcelRepository;
    private final HistoryRepository historyRepository;

    @Override
    public ParcelDTO getParcel(Long id) {
        log.info("Get parcel by id: {}", id);
        Parcel parcel = parcelRepository.getReferenceById(id);
        return buildParcelDTO(parcel);
    }

    @Override
    public List<HistoryParcelDTO> getHistory(Long id) {
        log.info("Get history about parcel by id: {}", id);
        return historyRepository.getHistoriesByParcelId(id).stream()
                .map(history -> buildHistoryDTO(history, id))
                .collect(Collectors.toList());
    }

    @Override
    public ParcelDTO takeParcel(Long id, String name) {
        log.info("Client {} take the parcel with id {}", name, id);
        Parcel parcel = parcelRepository.getReferenceById(id);
        if (parcel.getNameRecipient().equalsIgnoreCase(name)) {
            parcel.setStatus(ParcelStatus.RECEIVED);
        }
        parcelRepository.save(parcel);
        History history = createNewHistory(parcel, ParcelStatus.RECEIVED);
        historyRepository.save(history);
        return buildParcelDTO(parcel);
    }

    private ParcelDTO buildParcelDTO(Parcel parcel) {
        return ParcelDTO.builder()
                .address(parcel.getAddressRecipient())
                .type(parcel.getType())
                .index(parcel.getIndexRecipient())
                .id(parcel.getId())
                .name(parcel.getNameRecipient())
                .build();
    }

    private History createNewHistory(Parcel parcel, ParcelStatus status) {
        return History.builder()
                .date(Instant.now())
                .parcel(parcel)
                .status(status)
                .build();
    }

    private HistoryParcelDTO buildHistoryDTO(History history, Long parcelId) {
        return HistoryParcelDTO.builder()
                .id(history.getId())
                .status(history.getStatus().getValue())
                .date(history.getDate())
                .parcelId(parcelId)
                .build();
    }
}