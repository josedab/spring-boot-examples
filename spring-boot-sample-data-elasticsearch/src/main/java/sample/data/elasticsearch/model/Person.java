package sample.data.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "person", type = "person", shards = 1, replicas = 0, refreshInterval = "-1")
public class Person {

    @Id
    private String id;
    private String name;
    private String gender;
    private String email;

    public Person() {

    }

    public Person(String name, String gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Person[id=%s, name='%s', gender='%s', email='%s']", this.id,
                this.name, this.gender, this.email);
    }

}
