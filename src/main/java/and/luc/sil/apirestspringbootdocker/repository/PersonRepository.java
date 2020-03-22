package and.luc.sil.apirestspringbootdocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import and.luc.sil.apirestspringbootdocker.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
