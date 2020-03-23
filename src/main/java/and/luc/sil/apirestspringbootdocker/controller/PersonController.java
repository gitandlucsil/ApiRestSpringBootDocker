package and.luc.sil.apirestspringbootdocker.controller;

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

import and.luc.sil.apirestspringbootdocker.model.Person;
import and.luc.sil.apirestspringbootdocker.model.PersonV2;
import and.luc.sil.apirestspringbootdocker.services.PersonService;

@RestController
@RequestMapping("api/person/v1")
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
	
	@PostMapping
	public Person create(@RequestBody Person person) {
		System.out.println("Caiu no post");
		return personservice.create(person);
	}
	
	@PostMapping("/v2")
	public PersonV2 createV2(@RequestBody PersonV2 person) {
		return personservice.createV2(person);
	}
	
	
	@PutMapping
	public Person update(@RequestBody Person person) {
		return personservice.update(person);
	}	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		personservice.delete(id);
		return ResponseEntity.ok().build();
	}
}
