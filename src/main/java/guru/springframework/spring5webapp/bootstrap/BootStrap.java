package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationListenerMethodAdapter;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent>{


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publishRepository;

    
	
	public BootStrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publishRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publishRepository = publishRepository;
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		initData();
	}
	 private void initData(){

	        //Eric
	        Author eric = new Author("Eric", "Evans");
	        Publisher publisherAmerica = new Publisher("am","America");
	        
	        publishRepository.save(publisherAmerica);
	        
	        Book  ddd = new Book("Domain Driven Design", "1234",publisherAmerica);
	        eric.getBooks().add(ddd);
	        ddd.getAuthors().add(eric);

	        authorRepository.save(eric);
	        bookRepository.save(ddd);
	        
	      //  publisherAmerica.setBook(ddd);
	       


	        //Rod
	        Author rod = new Author("Rod", "Johnson");
	        Publisher publisherPakistan = new Publisher("pk","Pakistan");
	        publishRepository.save(publisherPakistan);
	        
	        Book noEJB = new Book("J2EE Development without EJB", "23444", publisherAmerica );
	        
	        Book ejb = new Book("J2EE Development EJB", "23444", publisherPakistan );
	        rod.getBooks().add(noEJB);
	        rod.getBooks().add(ejb);
	        
	        noEJB.getAuthors().add(rod);
	        ejb.getAuthors().add(rod);

	        authorRepository.save(rod);
	        bookRepository.save(noEJB);
	        bookRepository.save(ejb);
	        
	       
	    }
}
