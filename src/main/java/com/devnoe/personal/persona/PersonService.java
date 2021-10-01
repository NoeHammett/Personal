package com.devnoe.personal.persona;


import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

	private final PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<Person> getPerson(){
		return personRepository.findAll();
	}
	
	public Person getPersonById(Long personId) {
		Person person = personRepository.findById(personId).get();
		return person;
    }
	

	//Agrega persona y valida si el email ya fue ingresado
    public void addPerson(Person person) {
		Optional<Person> personOptional = personRepository.findPersonByEmail(person.getEmail());
		if(personOptional.isPresent()){
			throw new IllegalStateException("El email ya ha sido registrado a una persona previamente");
		}
		personRepository.save(person);
    }

	public void deletePerson(Long personId) {
		boolean exist = personRepository.existsById(personId);
		if(!exist){
			throw new IllegalStateException("Persona con Id "+ personId + " no existe");
		}
			personRepository.deleteById(personId);
		
	}

	@Transactional
	public void updatePerson(Person personR, Long id) {
		Person person = personRepository.findById(id).orElseThrow(()
		-> new IllegalStateException("La persona con id "+ personR + " no existe"));

		if(personR.getNombre() != null && personR.getNombre().length()>0 && !Objects.equals(person.getNombre(), personR.getNombre())){
			person.setNombre(personR.getNombre());
		} 

		if(personR.getPrimer_apellido() != null && personR.getPrimer_apellido().length()>0 && !Objects.equals(person.getPrimer_apellido(), personR.getPrimer_apellido())){
			person.setPrimer_apellido(personR.getPrimer_apellido());
		} 

		if(personR.getSegundo_apellido() != null && personR.getSegundo_apellido().length()>0 && !Objects.equals(person.getSegundo_apellido(), personR.getSegundo_apellido())){
			person.setSegundo_apellido(personR.getSegundo_apellido());
		} 

		 if(personR.getEmail()!= null && personR.getEmail().length()>0 && !Objects.equals(person.getEmail(), personR.getEmail())){
			Optional<Person> personOptional = personRepository.findPersonByEmail(personR.getEmail());
			if(personOptional.isPresent()){
				throw new IllegalStateException("El email ya ha sido registrado a una persona previamente");
			}
			person.setEmail(personR.getEmail());
		} 

	}

    
}
