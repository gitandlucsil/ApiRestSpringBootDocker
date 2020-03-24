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
	
	@GetMapping(value="/{id}",produces = {"application/json","application/xml","application/x-yaml"})
	public Person findById(@PathVariable("id") Long id) {
		return personservice.findById(id);
	}
	
	@GetMapping(produces = {"application/json","application/xml","application/x-yaml"})
	public List<Person> findAll() {
		return personservice.findAll();
	}
	
	@PostMapping(produces = {"application/json","application/xml","application/x-yaml"},consumes = {"application/json","application/xml","application/x-yaml"})
	public Person create(@RequestBody Person person) {
		System.out.println("Caiu no post");
		return personservice.create(person);
	}
	
	@PostMapping(value="/v2",produces = {"application/json","application/xml","application/x-yaml"},consumes = {"application/json","application/xml","application/x-yaml"})
	public PersonV2 createV2(@RequestBody PersonV2 person) {
		return personservice.createV2(person);
	}
	
	
	@PutMapping(produces = {"application/json","application/xml","application/x-yaml"},consumes = {"application/json","application/xml","application/x-yaml"})
	public Person update(@RequestBody Person person) {
		return personservice.update(person);
	}	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		personservice.delete(id);
		return ResponseEntity.ok().build();
	}
}
