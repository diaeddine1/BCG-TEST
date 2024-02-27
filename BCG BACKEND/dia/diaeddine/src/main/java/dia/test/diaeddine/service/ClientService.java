package dia.test.diaeddine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.test.diaeddine.dao.ClientRepository;
import dia.test.diaeddine.entities.Client;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void save(Client client){
        clientRepository.save(client);
    }
    public List<Client> findAll(){
        return clientRepository.findAll();
    }
}
