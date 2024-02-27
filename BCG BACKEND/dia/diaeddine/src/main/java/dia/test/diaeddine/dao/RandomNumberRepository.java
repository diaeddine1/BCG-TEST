package dia.test.diaeddine.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dia.test.diaeddine.entities.RandomNumber;

public interface RandomNumberRepository extends JpaRepository<RandomNumber,Integer> {
    
}
