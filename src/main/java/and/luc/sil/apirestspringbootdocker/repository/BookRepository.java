package and.luc.sil.apirestspringbootdocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import and.luc.sil.apirestspringbootdocker.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
