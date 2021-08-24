package com.microservicios.servicePhoto.DTO;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoDto {
    private String id;
    @NotEmpty(message = "the photo field cannot be empty")
    private String image;
}
