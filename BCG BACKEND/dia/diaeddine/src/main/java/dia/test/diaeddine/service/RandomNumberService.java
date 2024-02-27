package dia.test.diaeddine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dia.test.diaeddine.IDAO.Idao;
import dia.test.diaeddine.dao.RandomNumberRepository;
import dia.test.diaeddine.entities.RandomNumber;

@Service
public class RandomNumberService implements Idao<RandomNumber> {

    @Autowired
    private RandomNumberRepository randomNumberRepository;
    @Override
    public void save(RandomNumber o) {
        randomNumberRepository.save(o);
    }

    @Override
    public void delete(RandomNumber o) {
        randomNumberRepository.delete(o);
    }

    public void update(int id,RandomNumber o) {
        RandomNumber r=randomNumberRepository.findById(id).orElseThrow();
        r.setNumber(o.getNumber());
    }

    @Override
    public List<RandomNumber> findAll() {
        return randomNumberRepository.findAll();
    }

    @Override
    public RandomNumber findById(int id) {
        return randomNumberRepository.findById(id).orElse(new RandomNumber());
    }
    
}
