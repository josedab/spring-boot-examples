package sample.data.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import sample.data.elasticsearch.model.Person;

public interface PersonRepository extends ElasticsearchRepository<Person, String> {

    public Person findByName(String name);

    public Person findByGender(String gender);

    public Person findByEmail(String email);

}
