package guru.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repository.BookRepository;

@Controller
public class BookController {

	private BookRepository bookRepo;

	public BookController(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	
	@RequestMapping("/books")
	public String getBooks(Model model){
		 Iterable<Book> books =bookRepo.findAll();
		 model.addAttribute("books",bookRepo.findAll());
		 return "books";
	}
}
