package com.microservicios.servicePhoto.Controllers;

import com.microservicios.servicePhoto.DTO.PhotoDTO;
import com.microservicios.servicePhoto.Documents.Photo;
import com.microservicios.servicePhoto.Services.PhotoService;
import com.microservicios.servicePhoto.Services.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api")
public class PhotoController {

    private PhotoService service;
    private ErrorService errorService;

    @Autowired
    public PhotoController(PhotoService service, ErrorService errorService) {
        this.service = service;
        this.errorService = errorService;
    }

    @PostMapping(value = "savePhoto")
    public ResponseEntity<Photo> savePhoto(@Valid  @RequestBody Photo photo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,errorService.formatMessage(bindingResult));
        }else {
            Photo photoResult = service.savePhoto(photo);
            if (photoResult == null)
                return ResponseEntity.unprocessableEntity().build();
            return ResponseEntity.ok(photoResult);
        }
    }
    @GetMapping(value = "photos")
    public ResponseEntity<List<Photo>> photos(){
        List<Photo> photos =service.photos();
        if (photos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(photos);
    }
    @GetMapping(value = "photoById")
    public ResponseEntity<Photo> photoById(@Param(value = "id") int id, @Param(value = "typeId") String typeId){
        Photo photo =service.photoById(id,typeId);
        if (photo ==null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(photo);
    }
    @DeleteMapping(value = "deleteById")
    public ResponseEntity<String> deleteById(@Param(value = "id") int id,@Param(value = "typeId") String typeId){
        String result=service.deleteById(id,typeId);
        if (result!="removed")
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(result);
    }
    @PostMapping(value = "photosById")
    public ResponseEntity<List<Photo>> photosById(@RequestBody List<PhotoDTO> clientsDTO){
        List<Photo> photos =service.photosById(clientsDTO);
        if (photos ==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(photos);
    }

}
