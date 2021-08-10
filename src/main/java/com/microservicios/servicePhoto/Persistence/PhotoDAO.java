package com.microservicios.servicePhoto.Persistence;

import com.microservicios.servicePhoto.Documents.Photo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.io.Serializable;

public interface PhotoDAO extends MongoRepository<Photo, Serializable> {
    @Query("{ '_id': ?0}")
    public Photo findByIdAndType(ObjectId id);
    @Query(value="{ '_id': ?0}", delete = true)
    public Photo deleteByIdAndType(ObjectId id);
}
