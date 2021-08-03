package com.microservicios.servicePhoto.Repository;

import com.microservicios.servicePhoto.Documents.Photo;
import com.microservicios.servicePhoto.Persistence.PhotoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhotoRepositoryImp implements PhotoRepository {
    @Autowired
    private PhotoDAO photoDAO;
    @Override
    public Photo savePhoto(Photo photo) {
        return photoDAO.save(photo);
    }

    @Override
    public List<Photo> photos() {
        return photoDAO.findAll();
    }

    @Override
    public Photo photoById(int id, String typeId) {
        return photoDAO.findByIdAndType(id,typeId);
    }

    @Override
    public String deleteById(int id, String typeId) {
        Photo photo = this.photoById(id,typeId);
        String result="not found";
        if (photo !=null)
            try{
                //clientDAO.deleteByIdAndType(id,typeId);
                photoDAO.delete(photo);
                result="removed";
            }catch (Exception ex){
                result=ex.getMessage();
            }
        return result;
    }

}
