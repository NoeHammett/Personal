package com.devnoe.personal.persona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/Person", produces="application/json")
public class PersonController {
    
    private final PersonService personService;
        
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/getPerson")
	public List<Person> getPerson(){
       return personService.getPerson();
	}

    @GetMapping(path = "/getPerson/{personId}")
    public Person getPersonById (@PathVariable("personId") Long personId){
        return personService.getPersonById(personId);
    }


    @PostMapping(path = "/addPerson")
    public String addPerson(@RequestBody Person person){
        personService.addPerson(person);
        return "Persona Agregada Correctamente";
    }
    
    @DeleteMapping(path = "/deletePerson/{personId}")
    public String deletePerson(@PathVariable("personId") Long personId){
        personService.deletePerson(personId);
        return "Persona Eliminada Correctamente";
    }

    @PutMapping(path = "updatePerson/{personId}")
    public String updatePerson(@RequestBody Person person,
                            @PathVariable("personId") Long personId){
        personService.updatePerson(person,personId);
        return "Se actualizo la información correctamente";
    }

}
