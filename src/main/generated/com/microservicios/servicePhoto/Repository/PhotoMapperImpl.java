package com.microservicios.servicePhoto.Repository;

import com.microservicios.servicePhoto.DTO.PhotoDto;
import com.microservicios.servicePhoto.DTO.PhotoDto.PhotoDtoBuilder;
import com.microservicios.servicePhoto.Documents.Photo;
import com.microservicios.servicePhoto.Documents.Photo.PhotoBuilder;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-17T11:03:17-0500",
    comments = "version: 1.5.0.Beta1, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
public class PhotoMapperImpl implements PhotoMapper {

    @Override
    public PhotoDto photoToDTO(Photo photo) {
        if ( photo == null ) {
            return null;
        }

        PhotoDtoBuilder photoDto = PhotoDto.builder();

        photoDto.image( photo.getImage() );

        photoDto.id( photo.getId().toString() );

        return photoDto.build();
    }

    @Override
    public Photo DTOtophoto(PhotoDto photoDto) {
        if ( photoDto == null ) {
            return null;
        }

        PhotoBuilder photo = Photo.builder();

        photo.image( photoDto.getImage() );

        photo.id( null==photoDto.getId()?null:new org.bson.types.ObjectId(photoDto.getId()) );

        return photo.build();
    }
}
