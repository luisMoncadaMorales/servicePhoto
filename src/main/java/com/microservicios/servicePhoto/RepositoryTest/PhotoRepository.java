package com.microservicios.servicePhoto.RepositoryTest;

import com.microservicios.servicePhoto.Documents.Photo;

import java.util.List;

public interface PhotoRepository {
    Photo savePhoto(Photo photo);
    List<Photo> photos();
    Photo photoById(int id, String typeId);
    String deleteById(int id, String typeId);
}
