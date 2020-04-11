package and.luc.sil.apirestspringbootdocker.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import and.luc.sil.apirestspringbootdocker.model.Book;
import and.luc.sil.apirestspringbootdocker.services.BookService;

@RestController
@RequestMapping("api/book/v1")
public class BookController {

	@Autowired
	private BookService bookservice;
	
	@GetMapping(value="/{id}",produces = {"application/json","application/xml","application/x-yaml"})
	public Book findById(@PathVariable("id") Long id) {
		Book book = bookservice.findById(id);
		book.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return book;
	}
	
	@GetMapping(produces = {"application/json","application/xml","application/x-yaml"})
	public List<Book> findAll(@RequestParam(value="page",defaultValue = "0") int page,
			@RequestParam(value="limit",defaultValue = "12") int limit,
			@RequestParam(value="direction",defaultValue = "asc") String direction) {
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		Pageable pageable = PageRequest.of(page,limit,Sort.by(sortDirection,"title"));
		List<Book> books = bookservice.findAll(pageable);
		books.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getId())).withSelfRel()));
		return books;
	}
	
	@PostMapping(produces = {"application/json","application/xml","application/x-yaml"},consumes = {"application/json","application/xml","application/x-yaml"})
	public Book create(@RequestBody Book book) {
		Book p = bookservice.create(book);
		p.add(linkTo(methodOn(BookController.class).findById(p.getId())).withSelfRel());
		return p;
	}
	
	@PutMapping(produces = {"application/json","application/xml","application/x-yaml"},consumes = {"application/json","application/xml","application/x-yaml"})
	public Book update(@RequestBody Book book) {
		Book b = bookservice.update(book);
		b.add(linkTo(methodOn(BookController.class).findById(b.getId())).withSelfRel());
		return b;
	}	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		bookservice.delete(id);
		return ResponseEntity.ok().build();
	}
}
