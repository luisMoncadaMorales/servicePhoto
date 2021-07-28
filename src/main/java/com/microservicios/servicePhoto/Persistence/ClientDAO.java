package com.microservicios.servicePhoto.Persistence;

import com.microservicios.servicePhoto.Documents.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

public interface ClientDAO extends MongoRepository<Client, Serializable> {
}
