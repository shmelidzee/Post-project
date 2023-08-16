package com.post.domain.entities;

import com.post.domain.enums.ParcelStatus;
import com.post.domain.enums.ParcelType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PARCEL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name = "SQ_PARCEL_ID_GENERATOR", sequenceName = "PARCEL_ID_SEQ", allocationSize = 1)
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PARCEL_ID_GENERATOR")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private ParcelType type;

    @Column(name = "INDEX")
    private String indexRecipient;

    @Column(name = "ADDRESS_RECIPIENT")
    private String addressRecipient;

    @Column(name = "NAME_RECIPIENT")
    private String nameRecipient;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private ParcelStatus status;
}