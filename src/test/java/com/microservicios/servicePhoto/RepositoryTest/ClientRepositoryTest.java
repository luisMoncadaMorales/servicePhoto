package com.microservicios.servicePhoto.RepositoryTest;

import com.microservicios.servicePhoto.DTO.ClientDTO;
import com.microservicios.servicePhoto.Documents.Client;
import com.microservicios.servicePhoto.Persistence.ClientDAO;
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
public class ClientRepositoryTest {
    @InjectMocks
    private ClientRepositoryImp repository;

    @Mock
    private ClientRepositoryImp repositoryMock;
    @Mock
    private ClientDAO clientDAO;

    private Client client;
    private List<Client> clients;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        client=Client.builder()
                .number_id(1052)
                .type_id("cc")
                .photo("photo").build();
        clients= Arrays.asList(client);
        Mockito.when(clientDAO.save(client)).thenReturn(client);
        Mockito.when(clientDAO.findAll()).thenReturn(clients);
        Mockito.when(clientDAO.findByIdAndType(1052,"cc")).thenReturn(client);
    }
    @Test
    public void saveClientTest() {
        Client clientResult=repository.saveClient(client);
        Assertions.assertThat(clientResult).isNotNull();
    }
    @Test
    public void ClientsTest() {
        List<Client> clientsResult=repository.clients();
        Assertions.assertThat(clientsResult.size()).isEqualTo(1);
    }
    @Test
    public void clientByIdTest() {
        Client clientResult=repository.clientById(1052,"cc");
        Assertions.assertThat(clientResult.getPhoto()).isEqualTo("photo");
    }
    @Test
    public void deleteByIdTest() {
        repositoryMock.deleteById(1054,"cc");
        verify( repositoryMock ).deleteById( 1054,"cc" );
    }

}
