package com.microservicios.servicePhoto.Repository;

import com.microservicios.servicePhoto.DTO.PhotoDto;
import com.microservicios.servicePhoto.Documents.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PhotoMapper {
    PhotoMapper INSTANCE= Mappers.getMapper(PhotoMapper.class);
    @Mapping(expression = "java(photo.getId().toString())",target = "id")
    PhotoDto photoToDTO(Photo photo);
    @Mapping(expression = "java(null==photoDto.getId()?null:new org.bson.types.ObjectId(photoDto.getId()))",target = "id")
    Photo DTOtophoto(PhotoDto photoDto);
    default List<PhotoDto> photostoDTOs(List<Photo> photos){
        if(photos ==null){
            new ArrayList<>();
        }
        return photos.stream().map(this::photoToDTO).collect(Collectors.toList());
    }
}
