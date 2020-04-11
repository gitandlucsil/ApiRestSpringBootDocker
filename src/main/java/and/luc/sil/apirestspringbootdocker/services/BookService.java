package and.luc.sil.apirestspringbootdocker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import and.luc.sil.apirestspringbootdocker.model.Book;
import and.luc.sil.apirestspringbootdocker.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	public Book findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found for this id!"));
	}
	
	public List<Book> findAll(Pageable pageable) {
		var entities = repository.findAll(pageable).getContent();
		return entities;
	}
	
	public Book create(Book book) {
		return repository.save(book);
	}
	
	public Book update(Book book) {
		Book entity = repository.findById(book.getId()).orElseThrow(()-> new ResourceNotFoundException("No record found for this id!"));
		entity.setAuthor(book.getAuthor());
		entity.setLaunch_date(book.getLaunch_date());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		Book entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found for this id!"));
		repository.delete(entity);
	}
}
