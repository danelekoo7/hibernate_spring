package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

//    day2

    public List<Publisher> findAll(){
        Query query = entityManager.createQuery("SELECT p FROM Publisher p");
        List<Publisher> publishers = query.getResultList();
        return publishers;
    }




//    day1
    public void savePublisher(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public void update(Publisher publisher) {

        entityManager.merge(publisher);
    }

    public Publisher findById(long id)
    {
        return entityManager.find(Publisher.class, id);
    }

    public void delete(Publisher publisher) {
        entityManager.remove(entityManager.contains(publisher) ?
                publisher : entityManager.merge(publisher)); }
}
