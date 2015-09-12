package demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import demo.domain.Author;

@Repository
public interface AuthorRepository {

    public List<Author> findAll();

    public List<Author> findByName(String name);

    public Author save(Author author);
}
