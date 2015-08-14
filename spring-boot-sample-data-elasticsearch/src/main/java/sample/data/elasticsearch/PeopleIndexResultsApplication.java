package sample.data.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sample.data.elasticsearch.model.Person;
import sample.data.elasticsearch.repository.PersonRepository;
import sample.data.elasticsearch.service.PersonInjectorService;

// @SpringBootApplication
public class PeopleIndexResultsApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonInjectorService personInjectorService;

    @Override
    public void run(String... args) throws Exception {
        personRepository.deleteAll();
        personInjectorService.generateAndSaveVideos(50);
        fetchAllPeople();
    }

    private void fetchAllPeople() {
        System.out.println("People found with findAll():");
        System.out.println("-------------------------------");
        for (Person person : personRepository.findAll()) {
            System.out.println(person);
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PeopleIndexResultsApplication.class, args);
    }

}
