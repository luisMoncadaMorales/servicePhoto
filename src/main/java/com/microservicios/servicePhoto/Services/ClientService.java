package com.microservicios.servicePhoto.Services;

import com.microservicios.servicePhoto.DTO.ClientDTO;
import com.microservicios.servicePhoto.Documents.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(Client client);
    List<Client> clients();
    Client clientById(int id, String typeId);
    String deleteById(int id, String typeId);
    List<Client> clientsById(List<ClientDTO> clientsDto);
}
