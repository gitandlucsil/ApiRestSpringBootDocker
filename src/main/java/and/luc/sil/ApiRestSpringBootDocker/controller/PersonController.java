package and.luc.sil.ApiRestSpringBootDocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import and.luc.sil.ApiRestSpringBootDocker.model.Person;
import and.luc.sil.ApiRestSpringBootDocker.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personservice;
	
	@GetMapping(value="/{id}")
	public Person findById(@PathVariable("id") Long id) {
		return personservice.findById(id);
	}
	
	@GetMapping
	public List<Person> findAll() {
		return personservice.findAll();
	}
	
	@PostMapping()
	public Person create(@RequestBody Person person) {
		return personservice.create(person);
	}
	
	@PutMapping()
	public Person update(@RequestBody Person person) {
		return personservice.update(person);
	}	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		personservice.delete(id);
		return ResponseEntity.ok().build();
	}
}
