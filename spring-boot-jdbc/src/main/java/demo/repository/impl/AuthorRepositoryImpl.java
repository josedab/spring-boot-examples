package demo.repository.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import demo.domain.Author;
import demo.repository.AuthorRepository;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    private RowMapper<Author> authorRowMapper;
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public AuthorRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public List<Author> findAll() {
        final String sql = 
                "SELECT id, name, surname, description " +
                "FROM author";

        final List<Author> authors = jdbcTemplate.query(sql, authorRowMapper);

        return authors;
    }

    @Override
    public List<Author> findByName(String name) {

        final String sql = 
                "SELECT id, name, surname, description " +
                "FROM author " +
                "WHERE name = ?";

        final List<Author> authors = jdbcTemplate.query(sql, new Object[]{name}, authorRowMapper);

        return authors;
    }

    /* Save for the author with update, however queryForObject is 
     * encouraged to return the stored object 
     * */
    public Author save_withUpdate(Author author) {
        final String sql = 
                "INSERT INTO author(name,surname,description) " +
                "VALUES (?, ?, ?) ";
        jdbcTemplate.update(sql,  
                            new Object[]{
                                author.getName(),
                                author.getSurname(),
                                author.getDescription()
                            });
        return author;
    }

    @Override
    public Author save(Author author) {
        final String sql = 
                "INSERT INTO author(name,surname,description) " +
                "VALUES (?, ?, ?) " +
                "RETURNING * ";
        Author authorStored = jdbcTemplate.queryForObject(sql,  
                                            new Object[]{
                                                author.getName(),
                                                author.getSurname(),
                                                author.getDescription()
                                            },
                                            authorRowMapper);
        return authorStored;
    }


}
