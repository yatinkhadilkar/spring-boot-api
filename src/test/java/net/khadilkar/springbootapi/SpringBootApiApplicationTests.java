package net.khadilkar.springbootapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest
class SpringBootApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@LocalServerPort
	private int port;
		
	@Autowired
	private TestRestTemplate restTemplate;
		
	@Test
	public void testEndpoint() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
		String.class)).contains("Hello");
	}

}
