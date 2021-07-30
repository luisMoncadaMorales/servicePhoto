package com.microservicios.servicePhoto.Documents;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.io.Serializable;
@Document(collection = "Clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Photo implements Serializable {
    @Id
    @Positive(message = "the number_id must be greater than 0")
    private int number_id;
    @NotEmpty(message = "the type_id field cannot be empty")
    private String type_id;
    @NotEmpty(message = "the photo field cannot be empty")
    private String image;

}
