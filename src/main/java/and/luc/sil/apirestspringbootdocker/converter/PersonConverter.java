package and.luc.sil.apirestspringbootdocker.converter;

import java.util.Date;

import org.springframework.stereotype.Service;

import and.luc.sil.apirestspringbootdocker.model.Person;
import and.luc.sil.apirestspringbootdocker.model.PersonV2;

@Service
public class PersonConverter {

	public PersonV2 convertEntityToV2(Person person) {
		PersonV2 v2 = new PersonV2();
		v2.setId(person.getId());
		v2.setBirthday(new Date());
		v2.setFirstName(person.getFirstName());
		v2.setGender(person.getGender());
		v2.setAddress(person.getAddress());
		v2.setLastName(person.getLastName());
		return v2;
	}
	
	public Person convertV2ToEntity(PersonV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setGender(person.getGender());
		entity.setAddress(person.getAddress());
		entity.setLastName(person.getLastName());
		return entity;
	}
}
