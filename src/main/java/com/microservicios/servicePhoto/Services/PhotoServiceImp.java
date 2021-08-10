package com.microservicios.servicePhoto.Services;

import com.microservicios.servicePhoto.DTO.PhotoDto;
import com.microservicios.servicePhoto.RepositoryTest.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoServiceImp implements PhotoService {
    @Autowired
    private PhotoRepository repository;

    @Override
    public PhotoDto savePhoto(PhotoDto photo) {
        PhotoDto photoFound=null;
        if (photo.getId()!=null) {
             photoFound=this.photoById(photo.getId().toString());
        }
        if(photoFound==null){
            return repository.savePhoto(photo);
        }else{
            photoFound.setImage(photo.getImage());
            return repository.savePhoto(photoFound);
        }
    }

    @Override
    public List<PhotoDto> photos() {
        return repository.photos();
    }

    @Override
    public PhotoDto photoById(String id) {
        return repository.photoById(id);
    }

    @Override
    public String deleteById(String id) {
        return repository.deleteById(id);
    }

    @Override
    public List<PhotoDto> photosById(List<String> clientsDto) {
        List<PhotoDto> photos =new ArrayList<>();
        for (String id :clientsDto ) {
            PhotoDto photo =repository.photoById(id);
            if (photo !=null)
                photos.add(photo);
        }
        return photos;
    }

}
