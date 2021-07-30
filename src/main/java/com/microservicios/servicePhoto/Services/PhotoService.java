package com.microservicios.servicePhoto.Services;

import com.microservicios.servicePhoto.DTO.PhotoDTO;
import com.microservicios.servicePhoto.Documents.Photo;

import java.util.List;

public interface PhotoService {
    Photo savePhoto(Photo photo);
    List<Photo> photos();
    Photo photoById(int id, String typeId);
    String deleteById(int id, String typeId);
    List<Photo> photosById(List<PhotoDTO> clientsDto);
}
