package demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Author;
import demo.repository.AuthorRepository;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping("/author")
    public Author author(@RequestParam(value = "name", defaultValue = "John") String name,
                         @RequestParam(value = "surname", defaultValue = "Smith") String surname) {
        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);
        author.setDescription("Lorem ipsum");
        
        return author;
    }
    

    @RequestMapping("/author/find")
    public List<Author> findByName(@RequestParam(value = "name", required = true) String name) {
        return authorRepository.findByName(name);
    }
    
    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public Author author(@RequestBody Author author) {
        return authorRepository.save(author);
    }
    
    @RequestMapping(value = "/author/save", method = RequestMethod.GET)
    public Author authorSave(@RequestParam(value = "name", defaultValue = "John") String name,
                             @RequestParam(value = "surname", defaultValue = "Smith") String surname) {
        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);
        author.setDescription("Lorem ipsum");
        
        return authorRepository.save(author);
    }
    
    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
    
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoSuchElementException(NoSuchElementException e) {
        return e.getMessage();
    }
}
