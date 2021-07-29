package com.microservicios.servicePhoto.ServicesTest;

import com.microservicios.servicePhoto.DTO.ClientDTO;
import com.microservicios.servicePhoto.Documents.Client;
import com.microservicios.servicePhoto.Persistence.ClientDAO;
import com.microservicios.servicePhoto.RepositoryTest.ClientRepositoryImp;
import com.microservicios.servicePhoto.Services.ClientServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class ClienteServiceTest {
    @InjectMocks
    private ClientServiceImp service;
    @Mock
    private ClientRepositoryImp repository;
    private Client client;
    private ClientDTO clientDTO;
    private List<Client> clients;
    private  List<ClientDTO> clientsDTO;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        client=Client.builder()
                .number_id(1052)
                .type_id("cc")
                .photo("photo").build();
        clientDTO=ClientDTO.builder()
                .number_id(1052)
                .type_id("cc")
                .build();
        clients= Arrays.asList(client);
        clientsDTO=Arrays.asList(clientDTO);
        Mockito.when(repository.saveClient(client)).thenReturn(client);
        Mockito.when(repository.clients()).thenReturn(clients);
        Mockito.when(repository.clientById(1052,"cc")).thenReturn(client);
        Mockito.when(repository.deleteById(1052,"cc")).thenReturn("removed");
    }
    @Test
    public void saveClientTest() {
        Client clientResult=service.saveClient(client);
        Assertions.assertThat(clientResult).isNotNull();
    }
    @Test
    public void ClientsTest() {
        List<Client> clientsResult=service.clients();
        Assertions.assertThat(clientsResult.size()).isEqualTo(1);
    }
    @Test
    public void clientByIdTest() {
        Client clientResult=service.clientById(1052,"cc");
        Assertions.assertThat(clientResult.getPhoto()).isEqualTo("photo");
    }
    @Test
    public void deleteByIdTest() {
        String result=service.deleteById(1052,"cc");
        Assertions.assertThat(result).isEqualTo("removed");
    }
    @Test
    public void clientsByIdTest() {
        List<Client> clientsResult=service.clientsById(clientsDTO);
        Assertions.assertThat(clientsResult.size()).isEqualTo(1);
    }
}
