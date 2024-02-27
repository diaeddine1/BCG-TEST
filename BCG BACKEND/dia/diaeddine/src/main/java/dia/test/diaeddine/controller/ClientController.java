package dia.test.diaeddine.controller;

import java.util.List;

import dia.test.diaeddine.entities.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dia.test.diaeddine.entities.Client;
import dia.test.diaeddine.service.ClientService;
import dia.test.diaeddine.service.RandomNumberService;
import lombok.AllArgsConstructor;

@RequestMapping("client")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private RandomNumberService randomNumberService;

    @PostMapping("/predicted")
    public void SetNumber(@RequestBody Client client) {
        RandomNumber randomNumber = client.getRandomNumber();


        if (randomNumber.getId() == 0 || randomNumberService.findById(randomNumber.getId()) == null) {

            randomNumberService.save(randomNumber);
        }


        clientService.save(client);
    }
    @GetMapping
    public List<Client> findAll(){
        return clientService.findAll();
    }
}
