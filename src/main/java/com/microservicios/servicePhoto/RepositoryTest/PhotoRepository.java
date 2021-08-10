package com.microservicios.servicePhoto.RepositoryTest;

import com.microservicios.servicePhoto.DTO.PhotoDto;

import java.util.List;

public interface PhotoRepository {
    PhotoDto savePhoto(PhotoDto photoDto);
    List<PhotoDto> photos();
    PhotoDto photoById(String id);
    String deleteById(String id);
}
