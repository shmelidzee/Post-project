package com.post.command;

import com.post.domain.enums.ParcelStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "Parcel command")
public class UpdateParcelCommand {

    @Schema(description = "ID parcel")
    private Long id;

    @Schema(description = "Status parcel")
    private ParcelStatus status;
}