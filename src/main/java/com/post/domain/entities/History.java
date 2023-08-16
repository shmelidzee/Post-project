package com.post.domain.entities;

import com.post.domain.enums.ParcelStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "HISTORY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name = "SQ_HISTORY_ID_GENERATOR", sequenceName = "SQ_HISTORY_ID", allocationSize = 1)
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