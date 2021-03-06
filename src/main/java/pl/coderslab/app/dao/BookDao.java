package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

//    day2

    public List<Book> findAll(){
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        List<Book> books = query.getResultList();

        return books;
    }

    public List<Book> findAllWithRatingGreaterThen(Integer rating){
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating > :rating");
        query.setParameter("rating", rating);

        List<Book> books = query.getResultList();

        return books;
    }

    public List<Book> findAllWithPublisher(){
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN b.publishers");

        List<Book> books = query.getResultList();

        return books;
    }

    public List<Book> findAllWithAuthors(){
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN b.authors");

        List<Book> books = query.getResultList();

        return books;
    }



//    day1
    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book)); }
}