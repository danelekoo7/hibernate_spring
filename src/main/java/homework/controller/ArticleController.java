package homework.controller;


import homework.dao.ArticleDao;
import homework.dao.AuthorDao;
import homework.dao.CategoryDao;
import homework.entity.Article;
import homework.entity.Author;
import homework.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequestMapping("article")
public class ArticleController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @RequestMapping("add")
    @ResponseBody
    public String add() {
        Article article = new Article();
        Author author = new Author();
        Category category = new Category();

        category.setName("IT");
        category.setDescription("fajny artykul o javie");
        categoryDao.saveCategory(category);

        author.setFirstName("Daniel");
        author.setLastName("Jed");
        authorDao.saveAuthor(author);

        article.setAuthor(author);
        article.getCategories().add(category);
        article.setContent("rozwoj");
        article.setCreated(LocalDateTime.now());
        article.setTitle("nowosci w java 14");
        articleDao.saveArticle(article);

        return "id dodanego artykulu to " + article.getId();
    }

    @RequestMapping("get/{id}")
    @ResponseBody
    public String getArticle(@PathVariable Long id) {
        Article article = articleDao.findById(id);
        return article.toString();
    }

    @RequestMapping("update/{id}/{title}")
    @ResponseBody
    public String updateArticle(@PathVariable Long id, @PathVariable String title) {
        Article article = articleDao.findById(id);
        article.setTitle(title);
        article.setUpdated(LocalDateTime.now());
        articleDao.update(article);
        return article.toString();
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleteArticle(@PathVariable Long id) {
        Article article = articleDao.findById(id);
        articleDao.delete(article);
        return "deleted article " + id;
    }
}
