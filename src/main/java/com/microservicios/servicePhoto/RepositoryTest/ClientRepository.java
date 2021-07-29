package com.microservicios.servicePhoto.RepositoryTest;

import com.microservicios.servicePhoto.Documents.Client;

import java.util.List;

public interface ClientRepository {
    Client saveClient(Client client);
    List<Client> clients();
    Client clientById(int id, String typeId);
    String deleteById(int id, String typeId);
}
