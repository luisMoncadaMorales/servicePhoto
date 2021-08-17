package com.microservicios.servicePhoto.ServicesTest;

import com.microservicios.servicePhoto.DTO.PhotoDto;
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
    private PhotoDto photoDTO;
    private String id;
    private List<PhotoDto> photos;
    private  List<String> ids;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        photoDTO = PhotoDto.builder()
                .id("61114838890fad27a3f0480c")
                .image("photo").build();
        id = "61114838890fad27a3f0480c";
        photos = Arrays.asList(photoDTO);
        ids=Arrays.asList(id);
        Mockito.when(repository.savePhoto(photoDTO)).thenReturn(photoDTO);
        Mockito.when(repository.photos()).thenReturn(photos);
        Mockito.when(repository.photoById("61114838890fad27a3f0480c")).thenReturn(photoDTO);
        Mockito.when(repository.deleteById("61114838890fad27a3f0480c")).thenReturn("removed");
    }
    @Test
    public void saveClientTest() {
        PhotoDto photoResult =service.savePhoto(photoDTO);
        Assertions.assertThat(photoResult).isNotNull();
    }
    @Test
    public void ClientsTest() {
        List<PhotoDto> clientsResult=service.photos();
        Assertions.assertThat(clientsResult.size()).isEqualTo(1);
    }
    @Test
    public void clientByIdTest() {
        PhotoDto photoResult =service.photoById("61114838890fad27a3f0480c");
        Assertions.assertThat(photoResult.getImage()).isEqualTo("photo");
    }
    @Test
    public void deleteByIdTest() {
        String result=service.deleteById("61114838890fad27a3f0480c");
        Assertions.assertThat(result).isEqualTo("removed");
    }
    @Test
    public void clientsByIdTest() {
        List<PhotoDto> clientsResult=service.photosById(ids);
        Assertions.assertThat(clientsResult.size()).isEqualTo(1);
    }
}
