package com.microservicios.servicePhoto.RepositoryTest;

import com.microservicios.servicePhoto.DTO.PhotoDto;
import com.microservicios.servicePhoto.Documents.Photo;
import org.assertj.core.api.Assertions;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PhotoConvertTest {
    @InjectMocks
    private PhotoConvertImp photoConvertImp;

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
    }
    @Test
    public void photoToDTOTest() {
        PhotoDto result=photoConvertImp.photoToDTO(this.photo);
        Assertions.assertThat(result.getId()).isEqualTo(this.photoDTO.getId());
    }
    @Test
    public void DTOtophotoTest() {
        Photo result=photoConvertImp.DTOtophoto(this.photoDTO);
        Assertions.assertThat(result.getId()).isEqualTo(this.photo.getId());
    }
    @Test
    public void photostoDTOsTest() {
        List<PhotoDto> result=photoConvertImp.photostoDTOs(this.photos);
        Assertions.assertThat(result.size()).isEqualTo(1);
    }
}
