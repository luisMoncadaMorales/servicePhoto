package com.microservicios.servicePhoto.Documents;
import lombok.*;
import org.bson.types.ObjectId;
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
    private ObjectId id;
    @NotEmpty(message = "the photo field cannot be empty")
    private String image;

}
