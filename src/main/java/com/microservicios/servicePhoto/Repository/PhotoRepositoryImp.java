package com.microservicios.servicePhoto.Repository;

import com.microservicios.servicePhoto.DTO.PhotoDto;
import com.microservicios.servicePhoto.Documents.Photo;
import com.microservicios.servicePhoto.Persistence.PhotoDAO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PhotoRepositoryImp implements PhotoRepository {
    @Autowired
    private PhotoDAO photoDAO;

    @Override
    public PhotoDto savePhoto(PhotoDto photoDto) {
        Photo photo=PhotoMapper.INSTANCE.DTOtophoto(photoDto);
        Photo photoResult=photoDAO.save(photo);
        return PhotoMapper.INSTANCE.photoToDTO(photoResult);
    }

    @Override
    public List<PhotoDto> photos() {
        List<Photo> photos= photoDAO.findAll();
        return photos.stream().map(photo->PhotoMapper.INSTANCE.photoToDTO(photo)).collect(Collectors.toList());
    }

    @Override
    public PhotoDto photoById(String id) {
        Photo photo=photoDAO.findByIdAndType(new ObjectId(id));
        if(photo!=null){
            PhotoDto result=PhotoMapper.INSTANCE.photoToDTO(photo);
            return result;
        }
        return null;
    }

    @Override
    public String deleteById(String id) {
        PhotoDto photo = this.photoById(id);
        String result="not found";
        if (photo !=null)
            try{
                photoDAO.deleteByIdAndType(new ObjectId(id));
                result="removed";
            }catch (Exception ex){
                result=ex.getMessage();
            }
        return result;
    }

}
