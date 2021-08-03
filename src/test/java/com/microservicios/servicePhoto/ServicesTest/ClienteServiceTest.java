package com.microservicios.servicePhoto.ServicesTest;

import com.microservicios.servicePhoto.DTO.PhotoDTO;
import com.microservicios.servicePhoto.Documents.Photo;
import com.microservicios.servicePhoto.Repository.PhotoRepositoryImp;
import com.microservicios.servicePhoto.Services.PhotoServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class ClienteServiceTest {
    @InjectMocks
    private PhotoServiceImp service;
    @Mock
    private PhotoRepositoryImp repository;
    private Photo photo;
    private PhotoDTO photoDTO;
    private List<Photo> photos;
    private  List<PhotoDTO> clientsDTO;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        photo = Photo.builder()
                .number_id(1052)
                .type_id("cc")
                .image("photo").build();
        photoDTO = PhotoDTO.builder()
                .number_id(1052)
                .type_id("cc")
                .build();
        photos = Arrays.asList(photo);
        clientsDTO=Arrays.asList(photoDTO);
        Mockito.when(repository.savePhoto(photo)).thenReturn(photo);
        Mockito.when(repository.photos()).thenReturn(photos);
        Mockito.when(repository.photoById(1052,"cc")).thenReturn(photo);
        Mockito.when(repository.deleteById(1052,"cc")).thenReturn("removed");
    }
    @Test
    public void saveClientTest() {
        Photo photoResult =service.savePhoto(photo);
        Assertions.assertThat(photoResult).isNotNull();
    }
    @Test
    public void ClientsTest() {
        List<Photo> clientsResult=service.photos();
        Assertions.assertThat(clientsResult.size()).isEqualTo(1);
    }
    @Test
    public void clientByIdTest() {
        Photo photoResult =service.photoById(1052,"cc");
        Assertions.assertThat(photoResult.getImage()).isEqualTo("photo");
    }
    @Test
    public void deleteByIdTest() {
        String result=service.deleteById(1052,"cc");
        Assertions.assertThat(result).isEqualTo("removed");
    }
    @Test
    public void clientsByIdTest() {
        List<Photo> clientsResult=service.photosById(clientsDTO);
        Assertions.assertThat(clientsResult.size()).isEqualTo(1);
    }
}
