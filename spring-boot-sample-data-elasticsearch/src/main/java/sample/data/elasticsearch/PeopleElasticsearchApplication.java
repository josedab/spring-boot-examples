/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sample.data.elasticsearch.model.Person;
import sample.data.elasticsearch.repository.PersonRepository;
import sample.data.elasticsearch.service.PersonInjectorService;

@SpringBootApplication
public class PeopleElasticsearchApplication implements CommandLineRunner {

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
		SpringApplication.run(PeopleElasticsearchApplication.class, args);
	}

}
