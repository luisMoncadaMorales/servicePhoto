package com.microservicios.servicePhoto.Documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(collection = "Clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client implements Serializable {
    @Id
    private int number_id;
    private String type_id;
    private String photo;

}
