package com.microservicios.servicePhoto.Repository;

import com.microservicios.servicePhoto.Documents.Client;

import java.util.List;

public interface ClientRepository {
    Client saveClient(Client client);
}
