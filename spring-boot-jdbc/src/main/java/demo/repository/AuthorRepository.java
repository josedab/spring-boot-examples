package demo.repository;

import java.util.List;

import demo.domain.Author;


public interface AuthorRepository {

    public List<Author> findAll();

    public List<Author> findByName(String name);

    public Author save(Author author);
}
