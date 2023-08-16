package com.post.domain.entities;

import com.post.domain.enums.ParcelStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "HISTORY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name = "SQ_HISTORY_ID_GENERATOR", sequenceName = "HISTORY_ID_SEQ", allocationSize = 1)
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_HISTORY_ID_GENERATOR")
    @Column(name = "ID", nullable = false)
    private Long id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "PARCEL_ID", referencedColumnName = "ID")
    private Parcel parcel;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private ParcelStatus status;

    @Column(name = "DATE")
    private Instant date;
}