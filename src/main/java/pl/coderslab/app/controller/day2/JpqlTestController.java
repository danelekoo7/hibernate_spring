package pl.coderslab.app.controller.day2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

import java.util.List;

@Controller
public class JpqlTestController {
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookDao  bookDao;


    public JpqlTestController(PublisherDao publisherDao, AuthorDao authorDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }


    @GetMapping(value = "/publisher/all")
    @ResponseBody
    public List<Publisher> getAllPublishers(){
        List<Publisher> publisherList = publisherDao.findAll();

        return publisherList;
    }

    @GetMapping(value = "/author/all")
    @ResponseBody
    public List<Author> getAllAuthors(){
        List<Author> authors = authorDao.findAll();

        return authors;
    }



    @GetMapping(value = "/book/all")
    @ResponseBody
    public List<Book> getAll(){
        List<Book> books = bookDao.findAll();
        return books;
    }

    @GetMapping(value = "book/rating/{rating}")
    @ResponseBody
    public List<Book> findWithRatingGreaterThen(@PathVariable Integer rating){
        List<Book> books = bookDao.findAllWithRatingGreaterThen(rating);

        return books;
    }

    @GetMapping(value = "/book-with-publisher" )
    @ResponseBody
    public List<Book> findAllWithPublisher(){
        List<Book> books = bookDao.findAllWithPublisher();
        return books;
    }

    @GetMapping(value = "/book-with-author" )
    @ResponseBody
    public List<Book> findAllWithAuthor(){
        List<Book> books = bookDao.findAllWithAuthors();
        return books;
    }

}
