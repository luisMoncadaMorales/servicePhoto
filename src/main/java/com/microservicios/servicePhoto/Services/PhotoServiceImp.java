package com.microservicios.servicePhoto.Services;

import com.microservicios.servicePhoto.DTO.PhotoDTO;
import com.microservicios.servicePhoto.Documents.Photo;
import com.microservicios.servicePhoto.Repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoServiceImp implements PhotoService {
    @Autowired
    private PhotoRepository repository;
    @Override
    public Photo savePhoto(Photo photo) {
        return repository.savePhoto(photo);
    }

    @Override
    public List<Photo> photos() {
        return repository.photos();
    }

    @Override
    public Photo photoById(int id, String typeId) {
        return repository.photoById(id,typeId);
    }

    @Override
    public String deleteById(int id, String typeId) {
        return repository.deleteById(id,typeId);
    }

    @Override
    public List<Photo> photosById(List<PhotoDTO> clientsDto) {
        List<Photo> photos =new ArrayList<>();
        for (PhotoDTO photoDTO :clientsDto ) {
            Photo photo =repository.photoById(photoDTO.getNumber_id(), photoDTO.getType_id());
            if (photo !=null)
                photos.add(photo);
        }
        return photos;
    }

}
