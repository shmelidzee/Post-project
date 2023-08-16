package com.post.service.impl;

import com.post.command.RegisterParcelCommand;
import com.post.command.UpdateParcelCommand;
import com.post.dto.ParcelDTO;
import com.post.service.ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    @Override
    public ParcelDTO registerParcel(RegisterParcelCommand command) {
        return null;
    }

    @Override
    public ParcelDTO updateParcel(UpdateParcelCommand command) {
        return null;
    }
}
