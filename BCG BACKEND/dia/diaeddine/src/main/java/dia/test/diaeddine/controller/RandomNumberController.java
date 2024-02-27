package dia.test.diaeddine.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
@CrossOrigin(origins = "http://localhost:3000")
public class RandomNumberController {

    @GetMapping("/random")
    public int getrandomnumber(){

        return (int) (Math.random()*10)+1;

    }

}
