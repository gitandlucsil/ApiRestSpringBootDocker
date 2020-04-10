package and.luc.sil.apirestspringbootdocker.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import and.luc.sil.apirestspringbootdocker.model.Person;
import and.luc.sil.apirestspringbootdocker.model.PersonV2;
import and.luc.sil.apirestspringbootdocker.services.PersonService;

@CrossOrigin
@RestController
@RequestMapping("api/person/v1")
public class PersonController {

	@Autowired
	private PersonService personservice;
	
	@GetMapping(value="/{id}",produces = {"application/json","application/xml","application/x-yaml"})
	public Person findById(@PathVariable("id") Long id) {
		Person person = personservice.findById(id);
		person.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return person;
	}
	
	@GetMapping(produces = {"application/json","application/xml","application/x-yaml"})
	public List<Person> findAll() {
		List<Person> persons = personservice.findAll();
		persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getId())).withSelfRel()));
		return persons;
	}
	
	@PostMapping(produces = {"application/json","application/xml","application/x-yaml"},consumes = {"application/json","application/xml","application/x-yaml"})
	public Person create(@RequestBody Person person) {
		Person p = personservice.create(person);
		p.add(linkTo(methodOn(PersonController.class).findById(p.getId())).withSelfRel());
		return p;
	}
	
	@PostMapping(value="/v2",produces = {"application/json","application/xml","application/x-yaml"},consumes = {"application/json","application/xml","application/x-yaml"})
	public PersonV2 createV2(@RequestBody PersonV2 person) {
		return personservice.createV2(person);
	}
	
	
	@PutMapping(produces = {"application/json","application/xml","application/x-yaml"},consumes = {"application/json","application/xml","application/x-yaml"})
	public Person update(@RequestBody Person person) {
		Person p = personservice.update(person);
		p.add(linkTo(methodOn(PersonController.class).findById(p.getId())).withSelfRel());
		return p;
	}	
	
	@PatchMapping(value="/{id}",produces = {"application/json","application/xml","application/x-yaml"})
	public Person disablePerson(@PathVariable("id") Long id) {
		Person person = personservice.disablePerson(id);
		person.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return person;
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		personservice.delete(id);
		return ResponseEntity.ok().build();
	}
}
