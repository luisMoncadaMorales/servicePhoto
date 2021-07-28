package com.microservicios.servicePhoto.Services;

import com.microservicios.servicePhoto.Documents.Client;
import com.microservicios.servicePhoto.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    private ClientRepository repository;
    @Override
    public Client saveClient(Client client) {
        return repository.saveClient(client);
    }
}
