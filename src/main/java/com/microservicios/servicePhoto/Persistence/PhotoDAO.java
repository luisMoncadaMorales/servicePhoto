package com.microservicios.servicePhoto.Persistence;

import com.microservicios.servicePhoto.Documents.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.io.Serializable;

public interface PhotoDAO extends MongoRepository<Photo, Serializable> {
    @Query("{ '_id': ?0, 'type_id': ?1}")
    public Photo findByIdAndType(int id, String typeId);
    @Query(value="{ '_id': ?0, 'type_id': ?1}", delete = true)
    public Photo deleteByIdAndType(int id, String typeId);
}
