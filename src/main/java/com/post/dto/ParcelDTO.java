package com.post.dto;

import com.post.domain.enums.ParcelStatus;
import com.post.domain.enums.ParcelType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ParcelDTO {
    private Long id;
    private String name;
    private ParcelType type;
    private String index;
    private String address;
    private ParcelStatus status;
}