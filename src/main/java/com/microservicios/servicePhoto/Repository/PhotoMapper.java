package com.microservicios.servicePhoto.Repository;

import com.microservicios.servicePhoto.DTO.PhotoDto;
import com.microservicios.servicePhoto.Documents.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PhotoMapper {
    PhotoMapper INSTANCE= Mappers.getMapper(PhotoMapper.class);
    @Mapping(expression = "java(photo.getId().toString())",target = "id")
    PhotoDto photoToDTO(Photo photo);
    @Mapping(expression = "java(null==photoDto.getId()?null:new org.bson.types.ObjectId(photoDto.getId()))",target = "id")
    Photo DTOtophoto(PhotoDto photoDto);

}
