package com.microservicios.servicePhoto.RepositoryTest;

import com.microservicios.servicePhoto.Documents.Client;
import com.microservicios.servicePhoto.Persistence.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImp implements ClientRepository {
    @Autowired
    private ClientDAO clientDAO;
    @Override
    public Client saveClient(Client client) {
        return clientDAO.save(client);
    }

    @Override
    public List<Client> clients() {
        return clientDAO.findAll();
    }

    @Override
    public Client clientById(int id, String typeId) {
        return clientDAO.findByIdAndType(id,typeId);
    }

    @Override
    public String deleteById(int id, String typeId) {
        Client client= this.clientById(id,typeId);
        String result="not found";
        if (client!=null)
            try{
                //clientDAO.deleteByIdAndType(id,typeId);
                clientDAO.delete(client);
                result="removed";
            }catch (Exception ex){
                result=ex.getMessage();
            }
        return result;
    }

}
