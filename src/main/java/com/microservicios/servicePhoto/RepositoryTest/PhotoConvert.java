package com.microservicios.servicePhoto.RepositoryTest;

import com.microservicios.servicePhoto.DTO.PhotoDto;
import com.microservicios.servicePhoto.Documents.Photo;

import java.util.List;

public interface PhotoConvert {
    PhotoDto photoToDTO(Photo photo);
    Photo DTOtophoto(PhotoDto photoDto);
    List<PhotoDto> photostoDTOs(List<Photo> photos);
}
