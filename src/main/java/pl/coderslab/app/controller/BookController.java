package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

@Controller
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }


    @RequestMapping("/book/add")
    @ResponseBody
    public String hello() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setDescription("nauka javy");
        book.setRating(4);

        bookDao.saveBook(book);
        return "Id dodanej książki to:"
                + book.getId();
    }

    @RequestMapping("/addBookWithAuthors")
    @ResponseBody
    public String addBookWithAuthors() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setDescription("nauka javy");
        book.setRating(4);

        Author author1 = authorDao.findById(1);
        Author author2 = authorDao.findById(3);


        book.getAuthors().add(author1);
        book.getAuthors().add(author2);

        bookDao.saveBook(book);
        return "Id dodanej książki to:"
                + book.getId();
    }

    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }


    @GetMapping(value = "/addBookWithPublisher")
    @ResponseBody
    public Publisher createWithPublisher() {
        Book book = new Book();
        book.setTitle("Nowa ksiazka");
        book.setDescription("Z nowym opisem");

        bookDao.saveBook(book);

        Publisher publisher = new Publisher();
        publisher.setName("Nowy publisher");
        publisher.getBooks().add(book);

        publisherDao.savePublisher(publisher);

        return publisher;

    }

    @GetMapping(value = "/addBookWithPublisher2")
    @ResponseBody
    public String createWithPublisher2() {
        Book book = new Book();
        book.setTitle("Nowa ksiazka");
        book.setDescription("Z nowym opisem");

        bookDao.saveBook(book);

        Publisher publisher = new Publisher();
        publisher.setName("Nowy publisher");
        publisher.getBooks().add(book);

        publisherDao.savePublisher(publisher);

        return publisher.toString();

    }

}