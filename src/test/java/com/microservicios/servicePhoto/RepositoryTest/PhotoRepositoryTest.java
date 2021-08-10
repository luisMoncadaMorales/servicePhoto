package com.microservicios.servicePhoto.RepositoryTest;

import com.microservicios.servicePhoto.DTO.PhotoDto;
import com.microservicios.servicePhoto.Documents.Photo;
import com.microservicios.servicePhoto.Persistence.PhotoDAO;
import org.assertj.core.api.Assertions;
import org.bson.types.ObjectId;
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
public class PhotoRepositoryTest {
    @InjectMocks
    private PhotoRepositoryImp repository;

    @Mock
    private PhotoRepositoryImp repositoryMock;
    @Mock
    private PhotoDAO photoDAO;
    @Mock
    private PhotoConvertImp photoConvertService;

    private Photo photo;
    private List<Photo> photos;
    private PhotoDto photoDTO;
    private List<PhotoDto> photosDTO;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        photo = Photo.builder()
                .id(new ObjectId("61114838890fad27a3f0480c"))
                .image("photo").build();
        photos = Arrays.asList(photo);
        photoDTO = PhotoDto.builder()
                .id("61114838890fad27a3f0480c")
                .image("photo").build();
        photosDTO = Arrays.asList(photoDTO);
        Mockito.when(photoDAO.save(photo)).thenReturn(photo);
        Mockito.when(photoDAO.findAll()).thenReturn(photos);
        Mockito.when(photoDAO.findByIdAndType(new ObjectId("61114838890fad27a3f0480c"))).thenReturn(photo);
        Mockito.when(photoConvertService.photoToDTO(photo)).thenReturn(photoDTO);
        Mockito.when(photoConvertService.DTOtophoto(photoDTO)).thenReturn(photo);
        Mockito.when(photoConvertService.photostoDTOs(photos)).thenReturn(photosDTO);
    }
    @Test
    public void saveClientTest() {
        PhotoDto photoResult =repository.savePhoto(photoDTO);
        Assertions.assertThat(photoResult).isNotNull();
    }
    @Test
    public void ClientsTest() {
        List<PhotoDto> clientsResult=repository.photos();
        Assertions.assertThat(clientsResult.size()).isEqualTo(1);
    }
    @Test
    public void clientByIdTest() {
        PhotoDto photoResult =repository.photoById("61114838890fad27a3f0480c");
        Assertions.assertThat(photoResult.getImage()).isEqualTo("photo");
    }
    @Test
    public void deleteByIdTest() {
        repositoryMock.deleteById("61114838890fad27a3f0480c");
        verify( repositoryMock ).deleteById("61114838890fad27a3f0480c");
    }

}
