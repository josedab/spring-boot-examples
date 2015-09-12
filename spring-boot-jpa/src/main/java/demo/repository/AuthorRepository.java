package demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demo.domain.Author;
import demo.domain.Site;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
    public List<Author> findAll();
    public Site findByName(String name);
}
