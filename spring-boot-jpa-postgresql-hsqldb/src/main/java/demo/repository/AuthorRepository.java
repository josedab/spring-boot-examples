package demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demo.domain.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

    public List<Author> findAll();

    public List<Author> findByName(String name);
}
