package com.microservicios.servicePhoto.Controllers;

import com.microservicios.servicePhoto.DTO.ClientDTO;
import com.microservicios.servicePhoto.Documents.Client;
import com.microservicios.servicePhoto.Services.ClientService;
import com.microservicios.servicePhoto.Services.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api")
public class ClientController {

    private ClientService service;
    private ErrorService errorService;

    @Autowired
    public ClientController(ClientService service, ErrorService errorService) {
        this.service = service;
        this.errorService = errorService;
    }

    @PostMapping(value = "saveClient")
    public ResponseEntity<Client> saveClient(@Valid  @RequestBody Client client, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,errorService.formatMessage(bindingResult));
        }else {
            Client clientResult = service.saveClient(client);
            if (clientResult == null)
                return ResponseEntity.unprocessableEntity().build();
            return ResponseEntity.ok(clientResult);
        }
    }
    @GetMapping(value = "clients")
    public ResponseEntity<List<Client>> clients(){
        List<Client> clients=service.clients();
        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(clients);
    }
    @GetMapping(value = "clientById")
    public ResponseEntity<Client> clientById(@Param(value = "id") int id,@Param(value = "typeId") String typeId){
        Client client=service.clientById(id,typeId);
        if (client==null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(client);
    }
    @DeleteMapping(value = "deleteById")
    public ResponseEntity<String> deleteById(@Param(value = "id") int id,@Param(value = "typeId") String typeId){
        String result=service.deleteById(id,typeId);
        if (result!="removed")
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(result);
    }
    @PostMapping(value = "clientsById")
    public ResponseEntity<List<Client>> clientsById(@RequestBody List<ClientDTO> clientsDTO){
        List<Client> clients=service.clientsById(clientsDTO);
        if (clients==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clients);
    }

}
