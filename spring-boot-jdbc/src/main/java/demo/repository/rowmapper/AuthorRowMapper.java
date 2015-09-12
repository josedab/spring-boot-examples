package demo.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import demo.domain.Author;

@Component
@Immutable
public class AuthorRowMapper implements RowMapper<Author> {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String DESCRIPTION = "description";

    @Nonnull
    @Override
    public Author mapRow(@Nonnull ResultSet resultSet, int rowNum) throws SQLException {
        int id = resultSet.getInt(ID);
        String name = resultSet.getString(NAME);
        String surname = resultSet.getString(SURNAME);
        String description = resultSet.getString(DESCRIPTION);

        Author author = new Author();
        author.setId(id);
        author.setDescription(description);
        author.setName(name);
        author.setSurname(surname);
        return author;
    }
}
