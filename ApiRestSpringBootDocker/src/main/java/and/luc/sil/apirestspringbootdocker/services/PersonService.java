package and.luc.sil.apirestspringbootdocker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import and.luc.sil.apirestspringbootdocker.converter.PersonConverter;
import and.luc.sil.apirestspringbootdocker.model.Person;
import and.luc.sil.apirestspringbootdocker.model.PersonV2;
import and.luc.sil.apirestspringbootdocker.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;
	@Autowired
	PersonConverter converter;
	
	public Person findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found for this id!"));
	}
	
	public List<Person> findAll(Pageable pageable) {
		List<Person> entities = repository.findAll(pageable).getContent();
		return entities;
	}
	
	public List<Person> findPersonByName(String firstName, Pageable pageable) {
		List<Person> entities = repository.findPersonByName(firstName,pageable).getContent();
		return entities;
	}
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public PersonV2 createV2(PersonV2 person) {
		Person entity = converter.convertV2ToEntity(person);
		PersonV2 v2 = converter.convertEntityToV2(repository.save(entity));
		return v2;
	}
	
	public Person update(Person person) {
		Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No record found for this id!"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}
	
	@Transactional
	public Person disablePerson(Long id) {
		repository.disablePerson(id);
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found for this id!"));
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found for this id!"));
		repository.delete(entity);
	}
}
