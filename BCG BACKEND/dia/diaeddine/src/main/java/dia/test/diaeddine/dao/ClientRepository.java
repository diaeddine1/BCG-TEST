package dia.test.diaeddine.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dia.test.diaeddine.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    
}
