package org.josedab.kafka;

import org.josedab.kafka.GreetingApplication;
import org.junit.Test;
import org.junit.experimental.categories.ExcludeCategories;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestContextConfiguration.class)
@WebAppConfiguration
public class GreetingApplicationTests {

	@Test
	public void contextLoads() {
	}

}
