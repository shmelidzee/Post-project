package com.post.service.impl;

import com.post.dto.HistoryParcelDTO;
import com.post.dto.ParcelDTO;
import com.post.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    @Override
    public ParcelDTO getParcel(Long id) {
        return null;
    }

    @Override
    public List<HistoryParcelDTO> getHistory(Long id) {
        return null;
    }

    @Override
    public ParcelDTO takeParcel(Long id, String name) {
        return null;
    }
}