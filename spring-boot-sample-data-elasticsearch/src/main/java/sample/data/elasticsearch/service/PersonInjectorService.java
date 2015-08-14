package sample.data.elasticsearch.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.data.elasticsearch.model.Person;
import sample.data.elasticsearch.repository.PersonRepository;

@Service
public class PersonInjectorService {

    @Autowired
    private PersonRepository personRepository;

    public void generateAndSaveVideos(int n) {
        List<Person> peopleList = generateVideos(n);

        for (Person person : peopleList) {
            personRepository.save(person);
        }
    }

    public void generateAndSaveVideosOnBulk(int n) {
        List<Person> peopleList = generateVideos(n);
        personRepository.save(peopleList);
    }

    private List<Person> generateVideos(int n) {
        List<Person> resultPeople = new LinkedList<Person>();
        for (int i = 0; i < n; i++) {
            String name = "Name " + i;
            String gender = n % 2 == 0 ? "male" : "female";
            String email = "test" + i + "@gmail.com";
            Person person = new Person(name, gender, email);
            resultPeople.add(person);
        }
        return resultPeople;
    }

}
