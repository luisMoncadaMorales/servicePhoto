package com.microservicios.servicePhoto.Services;

import com.microservicios.servicePhoto.DTO.ClientDTO;
import com.microservicios.servicePhoto.Documents.Client;
import com.microservicios.servicePhoto.RepositoryTest.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    private ClientRepository repository;
    @Override
    public Client saveClient(Client client) {
        return repository.saveClient(client);
    }

    @Override
    public List<Client> clients() {
        return repository.clients();
    }

    @Override
    public Client clientById(int id, String typeId) {
        return repository.clientById(id,typeId);
    }

    @Override
    public String deleteById(int id, String typeId) {
        return repository.deleteById(id,typeId);
    }

    @Override
    public List<Client> clientsById(List<ClientDTO> clientsDto) {
        List<Client> clients=new ArrayList<>();
        for (ClientDTO clientDTO:clientsDto ) {
            Client client=repository.clientById(clientDTO.getNumber_id(),clientDTO.getType_id());
            if (client!=null)
                clients.add(client);
        }
        return clients;
    }

}
