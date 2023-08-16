package com.post.service;

import com.post.command.RegisterParcelCommand;
import com.post.command.UpdateParcelCommand;
import com.post.dto.ParcelDTO;

public interface ManagerService {

    ParcelDTO registerParcel(RegisterParcelCommand command);

    ParcelDTO updateParcel(UpdateParcelCommand command);
}