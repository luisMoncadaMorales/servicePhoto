package com.microservicios.servicePhoto.Controllers;

import com.microservicios.servicePhoto.Documents.Client;
import com.microservicios.servicePhoto.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
public class ClientController {

    private ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping(value = "saveClient")
    public ResponseEntity<Client> saveClient(){
        Client clientResult=service.saveClient(Client.builder()
                .number_id(1052)
                .type_id("cc")
                .photo("photo").build());
        return ResponseEntity.ok(clientResult);
    }
    @GetMapping(value = "client")
    public ResponseEntity<Client> client(){
        Client clientResult=Client.builder()
                .number_id(1052)
                .type_id("cc")
                .photo("photo").build();
        return ResponseEntity.ok(clientResult);
    }
}
