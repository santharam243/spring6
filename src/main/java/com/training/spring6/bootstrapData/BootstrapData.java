package com.training.spring6.bootstrapData;

import com.training.spring6.domain.Author;
import com.training.spring6.domain.Book;
import com.training.spring6.domain.Publisher;
import com.training.spring6.repositories.AuthorRepository;
import com.training.spring6.repositories.BookRepository;
import com.training.spring6.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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

        Publisher pub = new Publisher();
        pub.setPublisherName("Sandbox");
        pub.setAddress("Stark Street");
        pub.setCity("Winterfell");
        pub.setState("Kingslanding");
        pub.setZip(1111L);

        Publisher savedPublisher = publisherRepository.save(pub);

        dddSaved.setPublisher(savedPublisher);
        hpSaved.setPublisher(savedPublisher);

        ericSaved.getBooks().add(dddSaved);
        jkSaved.getBooks().add(hpSaved);
        dddSaved.getAuthors().add(ericSaved);
        hpSaved.getAuthors().add(jkSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(jkSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(hpSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count : " + authorRepository.count());
        System.out.println("Book Count : " + bookRepository.count());
        System.out.println("Publisher Count : " + publisherRepository.count());


    }
}
