package com.microservicios.servicePhoto.Persistence;

import com.microservicios.servicePhoto.Documents.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.io.Serializable;

public interface ClientDAO extends MongoRepository<Client, Serializable> {
    @Query("{ '_id': ?0, 'type_id': ?1}")
    public Client findByIdAndType(int id, String typeId);
    @Query(value="{ '_id': ?0, 'type_id': ?1}", delete = true)
    public Client deleteByIdAndType(int id, String typeId);
}
