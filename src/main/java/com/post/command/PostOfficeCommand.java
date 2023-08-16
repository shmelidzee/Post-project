package com.post.command;

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
@Schema(description = "Post office command")
public class PostOfficeCommand {
    @Schema(description = "Index")
    private String index;
    @Schema(description = "Name")
    private String name;
    @Schema(description = "Address")
    private String address;
}