package com.training.spring6.bootstrapData;

import com.training.spring6.domain.Author;
import com.training.spring6.domain.Book;
import com.training.spring6.repositories.AuthorRepository;
import com.training.spring6.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("John");

        Book ddd = new Book();
        ddd.setTitle("Data driven design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author jk = new Author();
        jk.setFirstName("JK");
        jk.setLastName("Rowling");

        Book hp = new Book();
        hp.setTitle("Harry Potter");
        hp.setIsbn("1234567");

        Author jkSaved = authorRepository.save(jk);
        Book hpSaved = bookRepository.save(hp);

        ericSaved.getBooks().add(dddSaved);
        jkSaved.getBooks().add(hpSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count : " + authorRepository.count());
        System.out.println("Book Count : " + bookRepository.count());


    }
}
