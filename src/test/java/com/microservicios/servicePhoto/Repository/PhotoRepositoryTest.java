package com.microservicios.servicePhoto.Repository;

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

    private Photo photo;
    private List<Photo> photos;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        photo = Photo.builder()
                .id(new ObjectId("61114838890fad27a3f0480c"))
                .image("photo").build();
        photos = Arrays.asList(photo);
        Mockito.when(photoDAO.save(photo)).thenReturn(photo);
        Mockito.when(photoDAO.findAll()).thenReturn(photos);
        Mockito.when(photoDAO.findByIdAndType(new ObjectId("61114838890fad27a3f0480c"))).thenReturn(photo);
    }
    @Test
    public void saveClientTest() {
        Photo photoResult =repository.savePhoto(photo);
        Assertions.assertThat(photoResult).isNotNull();
    }
    @Test
    public void ClientsTest() {
        List<Photo> clientsResult=repository.photos();
        Assertions.assertThat(clientsResult.size()).isEqualTo(1);
    }
    @Test
    public void clientByIdTest() {
        Photo photoResult =repository.photoById("61114838890fad27a3f0480c");
        Assertions.assertThat(photoResult.getImage()).isEqualTo("photo");
    }
    @Test
    public void deleteByIdTest() {
        repositoryMock.deleteById("61114838890fad27a3f0480c");
        verify( repositoryMock ).deleteById("61114838890fad27a3f0480c");
    }

}
