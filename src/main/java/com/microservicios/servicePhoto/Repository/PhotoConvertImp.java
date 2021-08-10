package com.microservicios.servicePhoto.Repository;

import com.microservicios.servicePhoto.DTO.PhotoDto;
import com.microservicios.servicePhoto.Documents.Photo;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PhotoConvertImp implements PhotoConvert{
    @Override
    public PhotoDto photoToDTO(Photo photo) {
        return PhotoDto.builder().id(photo.getId().toString()).image(photo.getImage()).build();
    }

    @Override
    public Photo DTOtophoto(PhotoDto photoDto) {
       if(photoDto.getId()==null){
           return Photo.builder().image(photoDto.getImage()).build();
       }
       return Photo.builder().id(new ObjectId(photoDto.getId())).image(photoDto.getImage()).build();
    }

    @Override
    public List<PhotoDto> photostoDTOs(List<Photo> photos) {
        List<PhotoDto> result= new ArrayList<>();
        for (Photo photo:photos) {
            result.add(this.photoToDTO(photo));
        }
        return result;
    }
}
