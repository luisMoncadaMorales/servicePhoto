package com.microservicios.servicePhoto.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoDTO {
    private int number_id;
    private String type_id;
}
