package com.post.service.impl;

import com.post.command.PostOfficeCommand;
import com.post.command.RegisterParcelCommand;
import com.post.command.UpdateParcelCommand;
import com.post.domain.entities.History;
import com.post.domain.entities.Parcel;
import com.post.domain.entities.Post;
import com.post.domain.enums.ParcelStatus;
import com.post.dto.ParcelDTO;
import com.post.repository.HistoryRepository;
import com.post.repository.ParcelRepository;
import com.post.repository.PostRepository;
import com.post.service.ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ParcelRepository parcelRepository;
    private final HistoryRepository historyRepository;
    private final PostRepository postRepository;

    @Override
    public ParcelDTO registerParcel(RegisterParcelCommand command) {
        log.info("Register parcel {}", command);
        Parcel parcel = buildParcel(command);
        parcelRepository.save(parcel);
        History history = createNewHistory(parcel, ParcelStatus.DECORATED);
        historyRepository.save(history);
        return buildParcelDTO(parcel);
    }

    @Override
    public ParcelDTO updateParcel(UpdateParcelCommand command) {
        log.info("Update parcel with id: {}", command.getId());
        Parcel parcel = parcelRepository.getReferenceById(command.getId());
        parcel.setStatus(command.getStatus());
        parcelRepository.save(parcel);
        History history = createNewHistory(parcel, command.getStatus());
        historyRepository.save(history);
        return buildParcelDTO(parcel);
    }

    @Override
    public void createNewPostOffice(PostOfficeCommand command) {
        log.info("Create new post office");
        Post post = createNewPost(command);
        postRepository.save(post);
    }

    private Parcel buildParcel(RegisterParcelCommand command) {
        return Parcel.builder()
                .addressRecipient(command.getAddress())
                .indexRecipient(command.getIndex())
                .type(command.getType())
                .nameRecipient(command.getName())
                .status(ParcelStatus.DECORATED)
                .build();
    }

    private ParcelDTO buildParcelDTO(Parcel parcel) {
        return ParcelDTO.builder()
                .address(parcel.getAddressRecipient())
                .type(parcel.getType())
                .status(parcel.getStatus())
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

    private Post createNewPost(PostOfficeCommand command) {
        return Post.builder()
                .address(command.getAddress())
                .index(command.getIndex())
                .name(command.getName())
                .build();
    }
}