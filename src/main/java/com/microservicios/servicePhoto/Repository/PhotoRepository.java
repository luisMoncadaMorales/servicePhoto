package com.microservicios.servicePhoto.Repository;

import com.microservicios.servicePhoto.DTO.PhotoDto;
import com.microservicios.servicePhoto.Documents.Photo;

import java.util.List;

public interface PhotoRepository {
    PhotoDto savePhoto(PhotoDto photoDto);
    List<PhotoDto> photos();
    PhotoDto photoById(String id);
    String deleteById(String id);
}
