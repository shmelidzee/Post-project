package com.post.command;

import com.post.domain.enums.ParcelType;
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
public class RegisterParcelCommand {

    @Schema(description = "Type parcel")
    private ParcelType type;

    @Schema(description = "Index")
    private String index;

    @Schema(description = "Address")
    private String address;

    @Schema(description = "Name")
    private String name;
}