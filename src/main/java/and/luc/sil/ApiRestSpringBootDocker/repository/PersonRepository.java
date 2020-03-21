package and.luc.sil.ApiRestSpringBootDocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import and.luc.sil.ApiRestSpringBootDocker.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
