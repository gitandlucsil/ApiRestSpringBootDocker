package and.luc.sil.ApiRestSpringBootDocker.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import and.luc.sil.ApiRestSpringBootDocker.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Andre");
		person.setLastName("Silva");
		person.setAddress("Pato Branco");
		person.setGender("Male");
		return person;
	}
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for(int index=0;index<=7;index++) {
			Person person = new Person();
			person.setId(counter.incrementAndGet());
			person.setFirstName("Andre");
			person.setLastName("Silva");
			person.setAddress("Pato Branco");
			person.setGender("Male");
			persons.add(person);
		}
		return persons;
	}
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}
}
