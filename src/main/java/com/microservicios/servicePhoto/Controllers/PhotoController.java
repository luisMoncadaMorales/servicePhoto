package com.microservicios.servicePhoto.Controllers;

import com.microservicios.servicePhoto.DTO.PhotoDto;
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
@RequestMapping(value = "apiPhoto")
public class PhotoController {

    private PhotoService service;
    private ErrorService errorService;

    @Autowired
    public PhotoController(PhotoService service, ErrorService errorService) {
        this.service = service;
        this.errorService = errorService;
    }

    @PostMapping(value = "savePhoto")
    public ResponseEntity<PhotoDto> savePhoto(@Valid  @RequestBody PhotoDto photo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,errorService.formatMessage(bindingResult));
        }else {
            PhotoDto photoResult = service.savePhoto(photo);
            if (photoResult == null)
                return ResponseEntity.unprocessableEntity().build();
            return ResponseEntity.ok(photoResult);
        }
    }
    @GetMapping(value = "photos")
    public ResponseEntity<List<PhotoDto>> photos(){
        List<PhotoDto> photos =service.photos();
        if (photos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(photos);
    }
    @GetMapping(value = "photoById")
    public ResponseEntity<PhotoDto> photoById(@Param(value = "id") String id){
        PhotoDto photo =service.photoById(id);
        if (photo ==null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(photo);
    }
    @DeleteMapping(value = "deleteById")
    public ResponseEntity<String> deleteById(@Param(value = "id") String id){
        String result=service.deleteById(id);
        if (result!="removed")
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(result);
    }
    @PostMapping(value = "photosById")
    public ResponseEntity<List<PhotoDto>> photosById(@RequestBody List<String> clientsDTO){
        List<PhotoDto> photos =service.photosById(clientsDTO);
        if (photos ==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(photos);
    }

}
