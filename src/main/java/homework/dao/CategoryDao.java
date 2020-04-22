package homework.dao;


import homework.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveCategory(Category category) {
        entityManager.persist(category);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
    }

}
