package com.microservicios.servicePhoto.Services;

import com.microservicios.servicePhoto.DTO.PhotoDto;
import com.microservicios.servicePhoto.Documents.Photo;

import java.util.List;

public interface PhotoService {
    PhotoDto savePhoto(PhotoDto photo);
    List<PhotoDto> photos();
    PhotoDto photoById(String id);
    String deleteById(String tid);
    List<PhotoDto> photosById(List<String> clientsDto);
}
