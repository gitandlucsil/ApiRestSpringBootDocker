package and.luc.sil.ApiRestSpringBootDocker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import and.luc.sil.ApiRestSpringBootDocker.model.Person;
import and.luc.sil.ApiRestSpringBootDocker.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;
	
	public Person findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found for this id!"));
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public Person update(Person person) {
		Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No record found for this id!"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found for this id!"));
		repository.delete(entity);
	}
}
