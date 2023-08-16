package com.post.service;

import com.post.dto.HistoryParcelDTO;
import com.post.dto.ParcelDTO;

import java.util.List;

public interface ClientService {

    ParcelDTO getParcel(Long id);

    List<HistoryParcelDTO> getHistory(Long id);

    ParcelDTO takeParcel(Long id, String name);
}