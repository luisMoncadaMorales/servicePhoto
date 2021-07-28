package com.microservicios.servicePhoto.Repository;

import com.microservicios.servicePhoto.Documents.Client;
import com.microservicios.servicePhoto.Persistence.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImp implements ClientRepository {
    @Autowired
    private ClientDAO clientDAO;
    @Override
    public Client saveClient(Client client) {
        return clientDAO.insert(client);
    }
}
