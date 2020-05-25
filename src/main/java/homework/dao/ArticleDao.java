package homework.dao;


import homework.entity.Article;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveArticle(Article article) {
        entityManager.persist(article);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public Article findById(Long id) {
        return entityManager.find(Article.class, id);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }
}
