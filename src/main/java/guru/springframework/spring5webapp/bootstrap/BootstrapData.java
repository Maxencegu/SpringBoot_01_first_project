package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123456");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        bookRepository.save(ddd);
        authorRepository.save(eric);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE developpement without EJB", "1515115");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        bookRepository.save(noEJB);
        authorRepository.save(rod);

        System.out.println("Started in Bootstrap");
        System.out.println("number of books : " + bookRepository.count());
    }
}
